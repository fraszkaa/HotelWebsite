'use strict';

angular.module('Registration')

    .factory('RegistrationService', ['$http', function ($http) {
        var service = {};
        service.Register = function (u, p, callback) {
            $http.post('/register', {username: u, password: p})
                .then(
                    function (data) {
                        callback({success: true, message: 'Registration completed'});
                    }, function (error) {
                        callback({success: false, message: 'Error occured during registration'});
                    });
        }
        return service;
    }]);
