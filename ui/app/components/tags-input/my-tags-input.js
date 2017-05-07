'use strict';

angular.module('myApp.myTagsInput', ['ngTagsInput'])

    .controller('MyTagsInputCtrl', ['$scope', function($scope) {
      $scope.tags = [];
    }])

    .directive('myTagsInput', function() {
      return {
        restrict: 'A',
        templateUrl: 'components/tags-input/my-tags-input.html',
        controller: 'MyTagsInputCtrl'
      };
    });
