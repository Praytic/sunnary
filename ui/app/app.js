'use strict';

angular.module('myApp', [
      'ngRoute',
      'ngAnimate',
      'myApp.main'
    ])

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

    .factory('Tag', ['$http', function($http) {
        return {
          get: function(query) {
            return $http.get('http://localhost:8888/api/tags?q=' + query);
          }
        }
      }
    ]);