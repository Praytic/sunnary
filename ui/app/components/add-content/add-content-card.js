'use strict';

angular.module('myApp.addContentCard', ['myApp.myTagsInput'])

    .directive('addContentCard', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/add-content/add-content-card.html',
        controller: ['$scope', function AddContentCtrl($scope) {
          $scope.tags = [];
          $scope.type = Object.freeze({
            TOOL: 0,
            ARTICLE: 1,
            PACK: 2
          });
          $scope.currentType = $scope.type.TOOL;
        }]
      };
    });