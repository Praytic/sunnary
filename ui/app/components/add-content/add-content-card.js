'use strict';

angular.module('sunnaryApp.addContentCard', ['sunnaryApp.sunnaryTagsInput'])

    .directive('addContentCard', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/add-content/add-content-card.html',
        controller: ['$scope', '$location','Content', function AddContentCtrl($scope, $location, Content) {
          $scope.type = Object.freeze({
            TOOL: 0,
            ARTICLE: 1,
            PACK: 2,
            name: function(selectedType) {
              for (var prop in $scope.type) {
                if ($scope.type[prop] == selectedType) {
                  return prop;
                }
              }
            }
          });
          $scope.currentType = $scope.type.TOOL;
          $scope.addContent = function(content) {
            Content.create(content).then(function() {
              $location.path('/');
            })
          };
        }]
      };
    });