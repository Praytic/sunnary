'use strict';

angular.module('sunnaryApp.routing', ['ngRoute'])

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
    }]);