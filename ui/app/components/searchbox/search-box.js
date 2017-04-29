'use strict';

angular.module('myApp.mySearchbox', ['ngTagsInput'])

    .controller('MySearchboxCtrl', ['$scope', '$http', function($scope, $http) {
      $scope.tags = [];

      $scope.query = function() {
        return $.map($scope.tags, function(n) {
          return n.id;
        }).join();
      };

      $scope.loadTags = function($query) {
        return $http.get('http://localhost:8888/api/get/tags', {cache: true}).then(function(response) {
          var responseTags = response.data;
          return responseTags.filter(function(tag) {
            return tag.id.toLowerCase().indexOf($query.toLowerCase()) != -1;
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
