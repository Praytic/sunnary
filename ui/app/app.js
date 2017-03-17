'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngAnimate',
  'myApp.view1',
  'myApp.version',
  'paasb'
]).
config(['$locationProvider', '$routeProvider',
  function($locationProvider, $routeProvider) {

  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
