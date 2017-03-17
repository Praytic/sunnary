'use strict';

angular.module('myApp.mySearchbox', ['paasb'])

.directive('mySearchBox', function() {
  return {
    restrict: 'A',
    templateUrl: 'components/searchbox/search-box.html'
  };
});
