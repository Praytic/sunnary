'use strict';

angular.module('sunnaryApp.mySearchbox', ['sunnaryApp.sunnaryTagsInput'])

    .directive('sunnarySearchBox', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/searchbox/sunnary-search-box.html'
      };
    });
