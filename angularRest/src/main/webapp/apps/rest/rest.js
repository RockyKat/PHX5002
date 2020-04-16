// MyCtrl1 Controler.
app.controller('RestController', ['$scope', 'UserFactory', 
	function ($scope, UserFactory) 
	{
	    $scope.bla = 'bla from controller';
	    UserFactory.get({}, 
	    function (userFactory) 
	    {
	        $scope.firstname = userFactory.firstName;
	        $scope.lastname = userFactory.lastName;
	    })
}]);