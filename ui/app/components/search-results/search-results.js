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
        scope: {
          contents: '='
        },
        templateUrl: 'components/search-results/search-results.html'
      };
    });
