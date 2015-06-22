/**
 * Created By Udesh Kumar
 * All Controller File
 * Date: 05/20/2015
 */


'use strict';

/* Controllers */

var primeDigitalControllers = angular.module('primeDigitalControllers', []);

/**
 * Prime Mathematic POC Controllers
 * To see which controller is scoped for which template see: js/app.js
 */
primeDigitalControllers.controller('appController', appController);
primeDigitalControllers.controller('DashboardCtrl', DashboardCtrl);
primeDigitalControllers.controller('StudentQuizCtrl', StudentQuizCtrl);
primeDigitalControllers.controller('TeacherDashboardCtrl', TeacherDashboardCtrl);
primeDigitalControllers.controller('QuizCtrl', QuizCtrl);
primeDigitalControllers.controller('ResultCtrl', ResultCtrl);
primeDigitalControllers.controller('QuestionCtrl', QuestionCtrl);
primeDigitalControllers.controller('QuizSubmitConfirm', QuizSubmitConfirm);



/**
 * @ngdoc controller
 * @name appController
 * @description
 *
 * Main Controller, will load on page load.
 * 
 * @param searchParams token
 *
 */
function appController($rootScope, $scope, $location, userServices, playerServices, appConstants) {
    var searchParams = $location.search(), token = '';

    //Check and set if token is passed
    if (searchParams['token']) {
        token = searchParams['token'];
    }
    /*
     function getQueryStringValue(key) {
     return unescape(window.location.search.replace(new RegExp("^(?:.*[&\\?]" + escape(key).replace(/[\.\+\*]/g, "\\$&") + "(?:\\=([^&]*))?)?.*$", "i"), "$1"));
     }
     token = getQueryStringValue('token');
     */


    //Get the Logged user information
    userServices.getUserInfo(token).then(function (data) {
        $rootScope.userInfo = data; // set User Information
    }, function (data) {
        console.log('User retrieval failed.')
    });

    // Set App Constants
    $rootScope.appConstants = appConstants;

    $rootScope.notSorted = function (obj) {
        if (!obj) {
            return [];
        }
        return Object.keys(obj);
    }

}

/**
 * @ngdoc controller
 * @name DashboardCtrl
 * @description
 *
 * Student Dashboard Controller
 * 
 */
function DashboardCtrl($rootScope, $scope, $location, playerServices) {
    //Redirect to Teacher Dashboard if its Teacher looged in
    if ($rootScope.userInfo.role == 'teacher') {
        $location.path('/dashboard/');
        return;
    }
    //Get all quiz records
    playerServices.getQuizDataService($rootScope.userInfo.id).then(function (data) {
        $scope.quizData = playerServices.getAllQuizData($rootScope.userInfo.id);
    }, function (data) {
        console.log('Quiz retrieval failed.')
    });

    //Get all student Quiz records
    playerServices.getStudentQuizDataService($rootScope.userInfo.id).then(function (data) {
        $scope.studentQuizData = playerServices.getAllStudentQuizData($rootScope.userInfo.id);
    }, function (data) {
        console.log('student quiz retrieval failed.')
    });
}


/**
 * @ngdoc controller
 * @name StudentQuizCtrl
 * @description
 *
 * To SHow the status of quiz for particular student
 * 
 * @param $routeParams sId  Student ID
 *
 */
function StudentQuizCtrl($rootScope, $routeParams, $scope, $location, playerServices, userServices) {

    //Redirect to Student Dashboard if its Student looged in
    if ($rootScope.userInfo.role == 'student') {
        $location.path('/');
        return;
    }
    // get Student ID and Class ID from route Params
    var sId = $routeParams.sId;
    var cId = $routeParams.cId;
  
    $rootScope.studentInfo = userServices.getClassStudentInfo(cId,sId);  //Get Particualr student record

    //Get all quiz records
    playerServices.getQuizDataService(sId).then(function (data) {
        $scope.quizData = playerServices.getAllQuizData(sId);
    }, function (data) {
        console.log('Quiz retrieval failed.')
    });

//Get all student Quiz records
    playerServices.getStudentQuizDataService(sId).then(function (data) {
        $scope.studentQuizData = playerServices.getAllStudentQuizData(sId);
    }, function (data) {
        console.log('student quiz retrieval failed.')
    });

    $scope.accordion = 0;

    //Change Accordion collapse
    $scope.collapse = function (testID) {
        if ($scope.studentQuizData[testID]) {
            $scope.accordion = testID;
        }
    }
}


/**
 * @ngdoc controller
 * @name TeacherDashboardCtrl
 * @description
 *
 * Teacher Dashboard Controller
 * Show the list of students
 * 
 */
function TeacherDashboardCtrl($rootScope, $scope, $location, userServices) {
    //Redirect to Student Dashboard if its Student looged in
    if ($rootScope.userInfo.role == 'student') {
        $location.path('/');
        return;
    }
    //Get all students records
    userServices.fetchStudentsData().then(function (data) {
        $rootScope.allStudents = userServices.getAllStudents();
    }, function (data) {
        console.log('User retrieval failed.')
    });
    
    $scope.accordion = 0;
    
    //Change Accordion collapse
    $scope.collapse = function (classID) {
        $scope.accordion = classID;
    }

}

/**
 * @ngdoc controller
 * @name QuizCtrl
 * @description
 *
 * To initialize the quiz
 * 
 * @param $routeParams sId Student ID
 * @param $routeParams quizId Quiz ID
 *
 */
function QuizCtrl($rootScope, $scope, $routeParams, $location, playerServices) {

    var searchParams = $location.search(), q = 0;

    //Check and set if token is passed
    if (searchParams['q']) {
        q = searchParams['q'];
    }

    //set Student ID from route Params
    var studentid = $routeParams.sId;

    // Set studentid as Logged user id if logged as student
    if ($rootScope.userInfo.role == 'student') {
        studentid = $rootScope.userInfo.id;
    }

    //Redirect to Student Dashboard if Wrong Quiz ID else Initialize the quiz as well
    if (!playerServices.setQuiz($routeParams.quizId, studentid)) {
        $location.path('/');
        return;
    }

    // Get Result Data in case already attempted
    $scope.quizDataObj = playerServices.getQuizData();

    // if already attempted, redirect to first question page. No need to show welcome page
    if (!$.isEmptyObject($scope.quizDataObj.resultArr)) {
        $location.path('/question/' + q);
        return;
    }

    // Get all questions
    $scope.questionArr = playerServices.getAllQuestion();
}


/**
 * @ngdoc controller
 * @name ResultCtrl
 * @description
 *
 * To Submit all the questions and show the result
 * 
 */
function ResultCtrl($rootScope, $scope, $location, playerServices) {

    //Redirect to Student Dashboard if quiz is not initialized
    if (!playerServices.checkQuizIniate()) {
        $location.path('/');
        return;
    }

    // Submit Questions
    playerServices.submitQuestions();

    // Get Result object
    var result = playerServices.getResult($rootScope.userInfo.id);
    $scope.result = result;
}


/**
 * @ngdoc controller
 * @name QuestionCtrl
 * @description
 *
 * Question Controller to show Questions
 * 
 * @param $routeParams qId   Question Id
 *
 */
function QuestionCtrl($rootScope, $scope, $routeParams, $location, playerServices, $modal) {

    //set Question ID from route Params
    var qId = parseInt($routeParams.qId);

    //Redirect to Student Dashboard if Wrong Questtion ID or quiz is not initialized
    if (!playerServices.checkQuizIniate() || !playerServices.showQuestion(qId)) {
        $location.path('/');
        return;
    }

    // Default value as empty
    $rootScope.studentName = '';

    // Default value as false
    $rootScope.quizDeactive = false;

    // Show Quiz details
    $rootScope.showQuizDetails = true;

    // get All Quesstions
    $scope.questionArr = playerServices.getAllQuestion();

    // Get Result Data in case already attempted
    $rootScope.quizDataObj = playerServices.getQuizData();

    // if already attempted, deactivate the question
    if (!$.isEmptyObject($rootScope.quizDataObj.resultArr)) {
        $rootScope.quizDeactive = true;
    }

    if ($rootScope.userInfo.role == 'teacher') {
        var StudentID = playerServices.getStudentID();
        $rootScope.studentName = $rootScope.studentInfo.first_name + ' ' + $rootScope.studentInfo.last_name;
    }

    $rootScope.quizTitle = playerServices.getQuizTitle();

    //set Current Question ID
    $scope.current = qId;

    // Total Question Count
    var totalQuestion = $scope.questionArr.length;

    // Next Question index
    $scope.next = parseInt(qId) + 1;
    // Default True valuww for next previous links show
    $scope.nextLink = true;
    $scope.prevLink = true;

    // Hide Next link if last question
    if ($scope.next > (totalQuestion - 1)) {
        $scope.nextLink = false;
    }
    // Previous Question index
    $scope.previous = parseInt(qId) - 1;

    // Hide Previous link if last question
    if ($scope.previous < 0) {
        $scope.prevLink = false;
    }
    $scope.submit = function () {
        playerServices.storeUserAnswerData(qId);
        $rootScope.quizDataObj = playerServices.getQuizData();
        var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: 'partials/modals/QuizSubmitConfirm.html',
            controller: 'QuizSubmitConfirm',
            size: '',
            resolve: {
                items: function () {
                    return $scope.items;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            $location.path('/result');
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });

    }

    var maxPages = $scope.maxPages = 5;
//
    $scope.previousPages = -1;
    $scope.nextPages = -1;
    var currentPage = qId;
    if (currentPage >= maxPages) {
        $scope.previousPages = ((parseInt(currentPage / maxPages) - 1) * maxPages) + maxPages - 1;
    }
    if (totalQuestion > (parseInt(currentPage / maxPages) + 1) * maxPages) {
        $scope.nextPages = (parseInt(currentPage / maxPages) + 1) * maxPages;
    }
    var arr = [];
    var firstPage = (parseInt((currentPage) / maxPages)) * maxPages;
    for (var i = firstPage; i < firstPage + 5; i++) {
        if (i > totalQuestion - 1) {
            break;
        }
        arr.push(i);
    }
    $scope.pageArr = arr;

    $scope.reset = function () {
        if ($rootScope.userInfo.role == 'teacher') {
            playerServices.activateQuestion(qId);
        }
        playerServices.resetQuestion(qId, $rootScope.userInfo.role);
        if ($rootScope.userInfo.role == 'teacher') {
            playerServices.deactivateQuestion(qId);
        }
        $rootScope.quizDataObj = playerServices.getQuizData();
    }

    $scope.revealAttempt = function () {
        playerServices.activateQuestion(qId);
        if (!playerServices.setUserAnswerData(qId)) {
            alert("Student didn't attempt this question");
        }
        playerServices.deactivateQuestion(qId);
        $rootScope.quizDataObj = playerServices.getQuizData();
    }

    $scope.revealAnswer = function () {
        playerServices.activateQuestion(qId);
        playerServices.revealAnswer(qId);
        playerServices.deactivateQuestion(qId);
        $rootScope.quizDataObj = playerServices.getQuizData();
    }

    /**
     * On View change
     */
    $scope.$on('$routeChangeStart', function (next, current) {
        // Show Quiz details
        $rootScope.showQuizDetails = false;
        // Store the User Answer State
        if (!$rootScope.quizDeactive) {
            playerServices.storeUserAnswerData(qId);
        }
    });
}


/**
 * @ngdoc controller
 * @name QuizSubmitConfirm
 * @description
 *
 * Modal for confirm before submit quiz
 * 
 */
function QuizSubmitConfirm($scope, $modalInstance) {

    $scope.ok = function () {
        $modalInstance.close();
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}