'use strict';

angular.module('sunnaryApp.sunnaryTagsInput', ['ngTagsInput'])

    .controller('SunnaryTagsInputCtrl', ['$scope', function($scope) {
      $scope.tags = [];
    }])

    .directive('sunnaryTagsInput', function() {
      return {
        restrict: 'A',
        templateUrl: 'components/tags-input/sunnary-tags-input.html',
        controller: 'SunnaryTagsInputCtrl'
      };
    });
