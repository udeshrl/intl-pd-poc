/**
 * Created By Udesh Kumar
 * Configuration File
 * Date: 05/20/2015
 */

'use strict';

/**
 * Configure the app with all its modules and dependencies.
 * @type {{config:function}}
 */

var primeDigitalApp = angular.module('primeDigitalApp', [
    'ngRoute',
    'ui.bootstrap',
    'primeDigitalControllers',
    'primeDigitalFilters',
    'primeDigitalUserServices',
    'AuthenticationServiceProvider',
    'primeDigitalPlayer'
]);

/**
 * Define App Constants
 */
primeDigitalApp.constant('appConstants', {
    appName: "Scholastic PR1ME Mathematics - POC",
    appURL: "http://localhost/prime-digital-poc/",
    copyright: "&#153; &#174; &#38; &copy; 2015, 2012 Scholastic Inc. All Rights Reserved."
});


/**
 * Configures the routes for the main views of this single page app. URLs are hash locations (http://example.com/#/home)
 *
 * These populate the ng-view section in index.html
 */
primeDigitalApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
                when('/quiz/:quizId/:sId', {
                    templateUrl: 'partials/quiz.html',
                    controller: 'QuizCtrl',
                    data: {
                        requireLogin: true
                    }
                }).
                when('/result', {
                    templateUrl: 'partials/result.html',
                    controller: 'ResultCtrl',
                    data: {
                        requireLogin: true
                    }
                }).
                when('/question/:qId', {
                    templateUrl: 'partials/question.html',
                    controller: 'QuestionCtrl',
                    data: {
                        requireLogin: true
                    }
                }).
                when('/dashboard', {
                    templateUrl: 'partials/teacher_dashboard.html',
                    controller: 'TeacherDashboardCtrl',
                    data: {
                        requireLogin: true
                    }
                }).
                when('/student/:cId/:sId', {
                    templateUrl: 'partials/student_quiz.html',
                    controller: 'StudentQuizCtrl',
                    data: {
                        requireLogin: true
                    }
                }).
                when('/report/:cId', {
                    templateUrl: 'partials/report.html',
                    controller: 'ReportCtrl',
                    data: {
                        requireLogin: true
                    }
                }).
                when('/', {
                    templateUrl: 'partials/student_dashboard.html',
                    controller: 'DashboardCtrl',
                    data: {
                        requireLogin: true
                    }
                }).
                when('/login', {
                    templateUrl: 'partials/login.html',
                    controller: 'LoginCtrl',
                    data: {
                        requireLogin: false
                    }
                }).
                otherwise({redirectTo: '/login'});
    }]);

/**
 *  
 */
primeDigitalApp.run(['$rootScope', '$location', '$http','userServices',
    function ($rootScope, $location, $http, userServices) {
        
        $rootScope.userInfo = userServices.getUser();
        
        // keep user logged in after page refresh
        if ($rootScope.userInfo) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.userInfo.authToken; // jshint ignore:line
        }

        $rootScope.$on('$routeChangeStart', function (event, next, current) {
            var requireLogin = next.data.requireLogin;
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login']) === -1;
            
            var loggedIn = $rootScope.userInfo;
            if (!loggedIn && requireLogin) {
                $rootScope.flashMessage = { "text": "Please login ", "type": "danger"};
                $location.path('/login');
            }else if(!restrictedPage && loggedIn){
                if($rootScope.userInfo.role == 'teacher'){
                    $location.path('/dashboard');
                }else{
                    $location.path('/');
                }
            }
        });
    }]);