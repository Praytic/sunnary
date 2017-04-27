'use strict';

angular.module('myApp.searchResults', [])

    .directive('searchResult', function () {
      return {
        restrict: 'A',
        scope: {
          content: '='
        },
        templateUrl: 'components/search-results/search-result.html'
      };
    })

    .directive('searchResults', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/search-results/search-results.html',
        controller: ['$scope', '$location', '$http', function SearchResultsCtrl($scope, $location, $http) {
          var query = $location.search().q;
          var tags = query.split(',');
          var successCallback = function (response) {
            $scope.contents = response.data;
          };
          var errorCallback = function (response) {
            $scope.contents = [];
          };
          $http.post('http://localhost:8888/api/search', tags).then(successCallback, errorCallback);
        }]
      };
    });
