/**
 * Created By Udesh Kumar
 * User Services File
 * Date: 05/25/2015
 */

'use strict';

/* Services */

var primeDigitalUserServices = angular.module('primeDigitalUserServices', ['ngResource']);

primeDigitalUserServices.factory('userServices', userServices);


/**
 * @ngdoc factory
 * @name userServices
 * @description
 *
 * User related Service
 * 
 */
function userServices($http, $q) {
    var students = [];

    /**
     * @ngdoc function
     * @name getUserInfo
     * @description
     *
     * Get User information from JSON
     * 
     * @param {string} token
     * 
     */
    var getUserInfo = function (token) {
        var def = $q.defer();
        if (token == '') {
//            token = 'STUDENT2001'; // Default token
            token = 'TEACHER1001'; // Default token
        }
        $http.get("data/mock/" + token + ".json")
                .success(function (data) {
                    def.resolve(data);
                })
                .error(function () {
                    def.reject("Failed to get User");
                });
        return def.promise;
    }

    /**
     * @ngdoc function
     * @name login
     * @description
     *
     * Get User information from JSON
     * 
     * @param {string} token
     * 
     */
    var login = function (username, password) {
        var def = $q.defer();

        $http({
            method: 'POST', // support GET, POST, PUT, DELETE
            url: 'api/v1/userLogin/userAuthentication',
            data: {user_name: username, password: password},
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            },
            timeout: 30000, // timeout abort AJAX
            cache: false
        }).
                success(function (data) {
                    def.resolve(data);
                }).
                error(function (data) {
                    def.reject("Failed to get User");
                });


//        $http.get("data/users.json")
//                .success(function (response) {
//                    var userInfo = {}, data = false;
//                    for (var i = 0, len = response.users.length; i < len; i++) {
//                        userInfo = response.users[i];
//                        if (userInfo.username == username && userInfo.username == password) {
//                            data = userInfo;
//                            break;
//                        }
//                    }
//                    def.resolve(data);
//                })
//                .error(function () {
//                    def.reject("Failed to get User");
//                });
        return def.promise;
    }

    /**
     * @ngdoc function
     * @name fetchStudentsData
     * @description
     *
     * Get all students record from JSON
     * 
     */
    var fetchStudentsData = function (tid) {
        var def = $q.defer();
        if (students.length > 0) {
            def.resolve();
        } else {
            $http.get("api/v1/teacher/getteacherClasses/" + tid)
                    .success(function (data) {
                        students = data.classType;
                        def.resolve(data);
                    })
                    .error(function () {
                        def.reject("Failed to get User");
                    });
        }
        return def.promise;
    }

    /**
     * @ngdoc function
     * @name getAllStudents
     * @description
     *
     * Return all students records
     * 
     */
    var getAllStudents = function () {
        return students;
    };

    /**
     * @ngdoc function
     * @name getClassStudentInfo
     * @description
     *
     * Return particular student info
     * 
     */
    var getClassStudentInfo = function (cId, sId) {
        var tempClassData = $.grep(students, function (e) {
            return e.id == cId;
        });
        var studentInfo = false;
        if (tempClassData.length > 0) {
            var classData = tempClassData[0];
            var tempStudentData = $.grep(classData.students, function (e) {
                return e.id == sId;
            });
            if (tempStudentData.length > 0) {
                studentInfo = tempStudentData[0];
            }

        }
        return studentInfo;
    };
    /**
     * @ngdoc function
     * @name getClassStudents
     * @description
     *
     * Return particular class Students
     * 
     */
    var getClassStudents = function (cId) {
        var tempClassData = $.grep(students, function (e) {
            return e.id == cId;
        });
        var allStudents = [];
        if (tempClassData.length > 0) {
            if (tempClassData[0]['students'])
                allStudents = tempClassData[0]['students'];
        }
        return allStudents;
    };

    /**
     * @ngdoc function
     * @name getUser
     * @description
     *
     * get Loggedin user entry from local storage
     * 
     */
    var getUser = function () {
        if (!localStorage.user) {
            return false;
        }
        return JSON.parse(localStorage.user);
    };

    /**
     * @ngdoc function
     * @name setUser
     * @description
     *
     * Add Logged in user entry in Local Storage
     * 
     */
    var setUser = function (user) {
        localStorage.user = JSON.stringify(user);
    };


    /**
     * @ngdoc function
     * @name deleteUser
     * @description
     *
     * Delete Logged in user entry from Local Storage
     * 
     */
    var deleteUser = function () {
        localStorage.removeItem('user');
    };


    return {
        getUserInfo: getUserInfo,
        login: login,
        getAllStudents: getAllStudents,
        fetchStudentsData: fetchStudentsData,
        getClassStudentInfo: getClassStudentInfo,
        getUser: getUser,
        setUser: setUser,
        deleteUser: deleteUser,
        getClassStudents: getClassStudents
    };
}
