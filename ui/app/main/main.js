'use strict';

angular.module('myApp.main', ['ngRoute', 'myApp.mySearchbox'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {
    templateUrl: 'main/main-page.html',
    controller: 'MainPageCtrl'
  });
}])

.controller('MainPageCtrl', ['$scope',
    function($scope) {
}]);