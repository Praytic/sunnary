'use strict';

angular.module('myApp.mySearchbox', ['ngTagsInput'])

    .controller('MySearchboxCtrl', ['$scope', '$http', 'Tag', function($scope, $http, Tag) {
      $scope.tags = [];

      $scope.query = function() {
        return $.map($scope.tags, function(n) {
          return n.id;
        }).join();
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

    .directive('mySearchBox', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/searchbox/search-box.html'
      };
    });
