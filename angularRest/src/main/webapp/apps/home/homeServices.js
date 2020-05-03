services.factory('HomeFactory', function ($resource) {
    return $resource('/ngdemo/rest/home/readTable', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});