var app = angular.module('wepla',['ngRoute','ngResource']);

app.config(['$routeProvider',function($routeProvider){

    $routeProvider.when('/',{
        templateUrl : 'views/LoginPage.html',
        controller : 'LoginController'
    }).when('/home',{
        templateUrl : 'views/HomePage.html',
        controller : 'HomeController'
    }).when('/admin',{
        templateUrl : 'views/AdminPage.html',
        controller : 'AdminController'
    });

}]);
