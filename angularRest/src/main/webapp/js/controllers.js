'use strict';

/* Controllers */


var app = angular.module('ngdemo.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});

// MyCtrl1 Controler.
app.controller('MyCtrl1', ['$scope', 'UserFactory', 
	function ($scope, UserFactory) {
    $scope.bla = 'bla from controller';
    UserFactory.get({}, function (userFactory) {
        $scope.firstname = userFactory.firstName;
        $scope.lastname = userFactory.lastName;

    })
}]);

// SEARCH Controller.
app.controller('SearchController', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('js/data.json').then(function(response) {
      $scope.artists = response.data;
      $scope.artistOrder = 'name';
  });
}]);

//DETAILS Controller.
app.controller('DetailsController', ['$scope', '$http', '$routeParams',
  function ($scope, $http, $routeParams) {
    $http.get('js/data.json').then(function(response) {
      $scope.artists = response.data;
      $scope.artistOrder = 'name';
      $scope.whichItem = $routeParams.itemId;
//      $scope.whichItem = 0;
      if ($routeParams.itemId > 0) 
      {
          $scope.prevItem = Number($routeParams.itemId) - 1;
      } 
      else 
      {
          $scope.prevItem = $scope.artists.length - 1;
      }

      if ($routeParams.itemId < $scope.artists.length-1) 
      {
          $scope.nextItem = Number($routeParams.itemId) + 1;
      } 
      else 
      {
          $scope.nextItem = 0;
      }
  });
}]);









