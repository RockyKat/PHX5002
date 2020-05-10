services.factory('HomeFactory', function ($resource) {
    return $resource('/ngdemo/rest/home', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});