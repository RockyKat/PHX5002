'use strict';

// Declare app level module which depends on filters, and services
//
var ngdemo = angular.module('ngdemo', [
					'ngdemo.filters', 
					'ngdemo.services', 
					'ngdemo.directives', 
					'ngdemo.controllers']).
    config(['$routeProvider', function ($routeProvider) 
    	{
        	$routeProvider.when('/view1', {templateUrl: 'partials/partial1.html', controller: 'MyCtrl1'});
        	$routeProvider.when('/search'     , {templateUrl: 'partials/search.html'  , controller: 'SearchController'});
        	$routeProvider.otherwise({redirectTo: '/view1'});
    	}]);



	

