'use strict';

angular.module('sunnaryApp.searchResults', [])

    .directive('searchResult', ['Content', function (Content) {
      return {
        restrict: 'A',
        scope: {
          content: '='
        },
        templateUrl: 'components/search-results/search-result.html',
        controller: ['$scope', 'Content',
          function SearchResultsCtrl($scope, Content) {
            $scope.upvote = function (content) {
              Content.upvote(content);
              content.likeCounter++;
            };
            $scope.view = function (content) {
              Content.view(content);
              content.viewCounter++;
            }
          }]

      };
    }])

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
