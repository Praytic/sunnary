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
            template: "<div add-content-card></div>"
          })
          .otherwise({redirectTo: '/'});
    }])

    .controller('MainPageCtrl', ['$scope', 'Tag', function($scope, Tag) {
      $scope.contents = [];
      $scope.query = function(tags) {
        return $.map(tags, function(tag) {
          return tag.id;
        }).join();
      };
      $scope.loadTags = function(query) {
        return Tag.getByQuery(query).then(function(response) {
          var responseTags = response.data;
          return responseTags.filter(function(tag) {
            return tag.id.toLowerCase().indexOf(query.toLowerCase()) != -1;
          });
        });
      }
    }])

    .directive('mainPage', function() {
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