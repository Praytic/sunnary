'use strict';

angular.module('sunnaryApp.addContentCard', ['sunnaryApp.sunnaryTagsInput'])

    .directive('addContentCard', function () {
      return {
        restrict: 'A',
        templateUrl: 'components/add-content/add-content-card.html',
        controller: ['$scope', '$location', '$http', 'Content', function AddContentCtrl($scope, $location, $http, Content) {
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

          $scope.$watch('addContentCard.contentLink', function() {
            var contentLink = $scope.addContentCard.contentLink;
            var encodedLink = encodeURI(contentLink);
            var metaDataLink = 'http://tools.buzzstream.com/metaDataService?url=' + encodedLink;
            var allowCorsLink = 'https://cors-anywhere.herokuapp.com/' + metaDataLink;
            $http.get(allowCorsLink).then(function(response) {
              var title = response.data.title;
              var description = response.data.description;
              var keywords = response.data.keywords;
              if (!$scope.addContentCard.contentTitle) {
                $scope.addContentCard.contentTitle = title;
              }
              if (!$scope.addContentCard.contentDescription) {
                $scope.addContentCard.contentDescription = description;
              }
              if (!$scope.tags.length < 0 && keywords) {
                $scope.tags = $.map(keywords.split(','), function(tag) {
                  return { id: tag };
                });
              }
            });
          }, true);
        }]
      };
    });