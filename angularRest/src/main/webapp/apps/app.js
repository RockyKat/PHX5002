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
        	$routeProvider.when('/rest', 
        							{templateUrl: 'apps/rest/rest.html', 
        						     controller:  'RestController'});
        	
        	$routeProvider.when('/search', 
        							{templateUrl: 'apps/search/search.html'  , 
        						     controller:  'SearchController' });
        								    
        	$routeProvider.when('/details/:itemId',
        							{templateUrl: 'apps/details/details.html'  , 
            				    	 controller:  'DetailsController'});
       			
        	$routeProvider.otherwise({redirectTo: '/rest'});
    	}]);



	

