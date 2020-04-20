'use strict';

/* Services */

var services = angular.module('ngdemo.services', ['ngResource']);

services.factory('UserFactory', function ($resource) {
    return $resource('/ngdemo/rest/users', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});
/* Services */


services.factory('SQLFactory', function ($resource) {
    return $resource('/ngdemo/rest/sql', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});