// SWAP Controller.
app.controller('SwapController', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('apps/data.json').then(function(response) {
      $scope.artists = response.data;
      $scope.artistOrder = 'name';
  });
}]);