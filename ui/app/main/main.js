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

    .controller('MainPageCtrl', ['$scope', '$http',
      function ($scope, $http) {
        $scope.contents = [];
        $scope.add = function () {
        };
        $scope.search = function (currentTags) {
          var successCallback = function (response) {
            $scope.contents = response.data;
            $scope.$apply();
          };
          var errorCallback = function (response) {
            $scope.contents = [];
            $scope.$apply();
          };
          $http.get('http://localhost:8888/api/get/content').then(successCallback, errorCallback);
        };
      }]);