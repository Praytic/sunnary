'use strict';

angular.module('myApp.main', [
  'ngRoute',
  'ngAnimate',
  'ui.bootstrap',
  'myApp.mySearchbox',
  'myApp.searchResults'])

    .config(['$routeProvider', function ($routeProvider) {
      $routeProvider.when('/', {
        templateUrl: 'main/main-page.html',
        controller: 'MainPageCtrl'
      });
    }])

    .controller('MainPageCtrl', ['$scope',
      function ($scope) {
        $scope.isCollapsed = false;
        $scope.contents = [];
        $scope.tags = [];
        $scope.selectedTags = [];
        $scope.add = function () {

        };
        $scope.search = function () {
          $.getJSON('http://sunnary.net/api/get/articles', function (data) {
            $scope.contents = data;
            $scope.$apply();
          })
        };
        $.getJSON('http://sunnary.net/api/get/tags', function (data) {
          $scope.tags = data;
        });
      }]);