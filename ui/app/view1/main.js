'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', ['$scope',
    function($scope) {
  $scope.availableSearchParams = [
    { key: "name", name: "Name", placeholder: "Name..." },
    { key: "city", name: "City", placeholder: "City..." },
    { key: "country", name: "Country", placeholder: "Country..." },
    { key: "emailAddress", name: "E-Mail", placeholder: "E-Mail...", allowMultiple: true },
    { key: "job", name: "Job", placeholder: "Job..." }
  ]
}]);