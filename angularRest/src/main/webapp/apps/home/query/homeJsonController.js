// HOME Json Controller.
app.controller('HomeJsonController', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('apps/cots.json').then(function(response) {
      $scope.artists = response.data;
      $scope.artistOrder = 'name';
  });
}]);
