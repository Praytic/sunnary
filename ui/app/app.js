'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngAnimate',
  'myApp.main'
]).
config(['$locationProvider', '$routeProvider',
  function($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider
        .when('/search', {
          template: "<div search-results></div>"
        })
        .when("/add", {
          template: "<div id='add-content' add-content-card></div>"
        })
        .otherwise({redirectTo: '/'});
  }]);
