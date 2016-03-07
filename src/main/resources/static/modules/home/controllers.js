'use strict';

angular.module('Home')

    .controller('HomeController',
        ['$scope', 'HomeService',
            function ($scope, HomeService) {
               /* $scope.ShowUser = function () {
                    HomeService.GetLoggedUser(function (response) {
                        if (response.success) {
                            $scope.username = response.data.username;
                            console.log($scope.username);
                        } else {
                            $scope.error = response.message;
                        }
                    });
                };*/


                $scope.ShowUser()
            }
        ]);


