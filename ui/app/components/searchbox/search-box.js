'use strict';

angular.module('myApp.mySearchbox', [])

    .directive('mySearchBox', ['$http',
      function ($http) {
        return {
          restrict: 'A',
          templateUrl: 'components/searchbox/search-box.html',
          link: function (scope, elem, attrs) {
            var successCallback = function (response) {
              var tags = $.map(response.data, function (n) {
                return n.id;
              });
              scope.currentTags = $('#my-tag-list').tags({
                suggestions: tags,
                caseInsensitive: true
              }).getTags();
            };
            var errorCallback = function (response) {
            };
            $http.get('http://localhost:8888/api/get/tags').then(successCallback, errorCallback);
            scope.getTags = function() { return 'java' };
          }
        };
      }]);
