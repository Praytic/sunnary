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
        controller: ['$scope', '$location', '$http', 'Content',
          function SearchResultsCtrl($scope, $location, $http, Content) {
            var query = $location.search().q;
            var tags = query.split(',');
            var successCallback = function (response) {
              $scope.$parent.contents = response.data;
            };
            var errorCallback = function (response) {
              $scope.$parent.contents = [];
              console.log(response);
            };
            Content.search(tags).then(successCallback, errorCallback);
        }]
      };
    });
