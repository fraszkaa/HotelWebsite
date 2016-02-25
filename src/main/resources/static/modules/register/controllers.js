'use strict';

angular.module('Registration')

    .controller('RegistrationController',
        ['$scope', '$rootScope', '$location', 'RegistrationService', 'AuthenticationService',
            function ($scope, $rootScope, $location, RegistrationService, AuthenticationService) {

                $scope.register = function () {
                    $scope.dataLoading = true;
                    RegistrationService.Register($scope.username, $scope.password, function (response) {
                        if (response.success) {
                            $location.path('/login');
                            $scope.dataLoading = false;
                        } else {
                            $scope.error = response.message;
                            $scope.dataLoading = false;
                        }
                    })
                }
            }]);
