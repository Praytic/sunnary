'use strict';

angular.module('myApp.mySearchbox', [])

    .directive('mySearchBox', function () {
        return {
          restrict: 'A',
          templateUrl: 'components/searchbox/search-box.html',
          link: function (scope, elem, attrs){
            $.getJSON('http://sunnary.net/api/get/tags', function (data) {
              var tags = $.map(data, function (n) {
                return n.id;
              });
              $('#my-tag-list').tags({
                suggestions: tags
              });
            });
          }
        };
      });
