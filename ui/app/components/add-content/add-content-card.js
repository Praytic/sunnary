'use strict';

angular.module('myApp.addContentCard', [])

    .directive('addContentCard', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/add-content/add-content-card.html',
        controller: ['$scope', '$location', '$http', 'Content',
          function AddContentCtrl($scope, $location, $http, Content) {
            $scope.type = Object.freeze({
              TOOL: 0,
              ARTICLE: 1,
              PACK: 2
            });
            $scope.currentType = $scope.type.TOOL;
          }]
      };
    });