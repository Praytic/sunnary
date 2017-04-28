'use strict';

angular.module('myApp.mySearchbox', ['ngTagsInput'])

    .controller('MySearchboxCtrl', ['$scope', '$http', function($scope, $http) {
      $scope.tags = [
        { id: 'Tag1' },
        { id: 'Tag2' },
        { id: 'Tag3' }
      ];

      $scope.loadTags = function(query) {
        return $http.get('http://localhost:8888/api/get/tags');
      };
    }])

    .directive('mySearchBox', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/searchbox/search-box.html'
      };
    });
