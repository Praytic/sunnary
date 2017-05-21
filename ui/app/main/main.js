'use strict';

angular.module('sunnaryApp.main', [
  'ngAnimate',
  'ui.bootstrap',
  'sunnaryApp.mySearchbox',
  'sunnaryApp.searchResults',
  'sunnaryApp.addContentCard'])

    .controller('MainPageCtrl', ['$scope', 'Tag', function($scope, Tag) {
      $scope.contents = [];
      $scope.asQueryArray = function(tags) {
        return $.map(tags, function(tag) {
          return encodeURIComponent(tag.id);
        });
      };
      $scope.asQuery = function(tags) {
        return encodeURIComponent($scope.asQueryArray(tags).join());
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
    });