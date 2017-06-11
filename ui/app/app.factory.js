'use strict';

angular.module('sunnaryApp.factory', [])

    .constant('serverApiUrl', 'http://localhost:8002/api')

    .factory('Tag', ['$http', 'serverApiUrl', function($http, serverApiUrl) {
      return {
        get: function() {
          return $http.get(serverApiUrl + '/tags');
        },
        getByQuery: function(query) {
          return $http.get(serverApiUrl + '/tags?q=' + query);
        }
      }
    }])

    .factory('Content', ['$http', 'serverApiUrl', function($http, serverApiUrl) {
      return {
        search: function(tags) {
          return $http.post(serverApiUrl + '/content/search', tags);
        },
        create: function(content) {
          return $http.post(serverApiUrl + '/content/create', content);
        },
        upvote: function(content) {
          return $http.post(serverApiUrl + '/stats/' + content.id + '/upvote');
        },
        view: function(content) {
          return $http.post(serverApiUrl + '/stats/' + content.id + '/view');
        }
      }
    }]);