services.factory('SQLFactory', function ($resource) {
    return $resource('/ngdemo/rest/sql', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});