'use strict';

angular.module('myApp.addContentCard', [])

    .directive('addContentCard', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/add-content/add-content-card.html'
      };
    });