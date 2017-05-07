'use strict';

angular.module('myApp.mySearchbox', ['myApp.myTagsInput'])

    .directive('mySearchBox', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/searchbox/search-box.html'
      };
    });
