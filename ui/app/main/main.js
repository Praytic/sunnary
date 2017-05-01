'use strict';

angular.module('myApp.main', [
  'ngRoute',
  'ngAnimate',
  'ui.bootstrap',
  'myApp.mySearchbox',
  'myApp.searchResults',
  'myApp.addContentCard'])

    .config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');
      $routeProvider
          .when('/search', {
            template: "<div search-results></div>"
          })
          .when("/add", {
            template: "<div id='add-content' add-content-card></div>"
          })
          .otherwise({redirectTo: '/'});
    }])

    .controller('MainPageCtrl', ['$scope', function($scope) {
      $scope.contents = [];
    }])

    .directive('mainPage', function () {
      return {
        restrict: 'A',
        templateUrl: 'main/main-page.html',
        controller: 'MainPageCtrl'
      };
    })

    .factory('Tag', ['$http', function($http) {
      return {
        get: function() {
          return $http.get('http://localhost:8888/api/tags');
        },
        getByQuery: function(query) {
          return $http.get('http://localhost:8888/api/tags?q=' + query);
        }
      }
    }])

    .factory('Content', ['$http', function($http) {
      return {
        search: function(tags) {
          return $http.post('http://localhost:8888/api/content/search', tags);
        }
      }
    }]);