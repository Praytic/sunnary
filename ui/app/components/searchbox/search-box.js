'use strict';

angular.module('myApp.mySearchbox', [])

    .directive('mySearchBox', ['$http',
      function ($http) {
        return {
          restrict: 'A',
          templateUrl: 'components/searchbox/search-box.html',
          link: function (scope, elem, attrs) {
            var tags = new Bloodhound({
              datumTokenizer: Bloodhound.tokenizers.whitespace,
              queryTokenizer: Bloodhound.tokenizers.whitespace,
              remote: {
                url: 'http://localhost:8888/api/get/tags'
              }
            });

            $('#search-box-panel').find('input').typeahead(null, {
              name: 'tags',
              display: 'id',
              source: tags
            });
            scope.getTags = function() {
              return $('#tags-input').tagsinput('items');
            };
          }
        };
      }]);
