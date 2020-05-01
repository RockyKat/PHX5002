services.factory('SQLFactory', function ($resource) {
    return $resource('/ngdemo/rest/sql/demo', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});