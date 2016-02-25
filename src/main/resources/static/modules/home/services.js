'use strict';

angular.module('Home')

    .factory('HomeService', ['$http', function ($http) {
        var service = {};
        service.GetLoggedUser = function (callback) {
            $http.get('/user/loggedUserDetails')
                .then(function (result) {
                    callback({success: true, message: 'Data fetched', data: result.data});
                }, function (error) {
                    callback({success: false, message: 'Error occured during user data fetch'});
                });
        };
        return service;
    }]);
