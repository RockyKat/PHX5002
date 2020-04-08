'use strict';

// Declare app level module which depends on filters, and services
//
var myApp = angular.module('ngdemo', ['ngdemo.filters', 'ngdemo.services', 'ngdemo.directives', 'ngdemo.controllers']).
    config(['$routeProvider', function ($routeProvider) 
    	{
        	$routeProvider.when('/view1', {templateUrl: 'partials/partial1.html', controller: 'MyCtrl1'});
        	$routeProvider.otherwise({redirectTo: '/view1'});
    	}]);

	myApp.controller('MyController', function MyController($scope,$http)
	{
		$http.get('js/data.json').then(function(response) 
		{
		   	$scope.artists = response.data;	   
		   	$scope.artistOrder = "name";
		});
	});

