

//DETAILS Controller.
app.controller('DetailsController', ['$scope', '$http', '$routeParams',
  function ($scope, $http, $routeParams) {
    $http.get('apps/data.json').then(function(response) {
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