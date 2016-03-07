'use strict';

// declare modules
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('Registration', []);
angular.module('BasicHttpAuthExample', [
        'Authentication',
        'Registration',
        'Home',
        'ngRoute',
        'ngCookies'
    ])

    .config(['$routeProvider', function ($routeProvider) {

        $routeProvider
            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'modules/login/login.html'
            })
            .when('/register', {
                controller: 'RegistrationController',
                templateUrl: 'modules/register/register.html'
            })

            .when('/', {
                controller: 'HomeController',
                templateUrl: 'modules/home/home.html'
            });

            /*.otherwise({redirectTo: '/login'});*/
    }])

    .run(['$rootScope', '$location', '$cookieStore', '$http',
        function ($rootScope, $location, $cookieStore, $http) {
            // keep user logged in after page refresh
            $rootScope.globals = $cookieStore.get('globals') || {};
            if ($rootScope.globals.currentUser) {
                $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
            }

            $rootScope.$on('$locationChangeStart', function (event, next, current) {
                // redirect to login page if not logged in
                //if ($location.path() !== '/login' && !$rootScope.globals.currentUser && $location.path() !== '/register') {
                //    $location.path('/login');
                //}
                //else if($location.path() == '/login' || $location.path() == '/register'){
                //     $location.path('/');
                //}
            });
        }]);
