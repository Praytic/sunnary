'use strict';

angular.module('myApp.main', ['ngRoute', 'myApp.mySearchbox'])

    .config(['$routeProvider', function ($routeProvider) {
      $routeProvider.when('/', {
        templateUrl: 'main/main-page.html',
        controller: 'MainPageCtrl'
      });
    }])

    .controller('MainPageCtrl', ['$scope',
      function ($scope) {
        $scope.tags = [];
        $.getJSON('http://sunnary.net/api/get/tags', function (data) {
          $scope.tags = data;
        });
      }]);