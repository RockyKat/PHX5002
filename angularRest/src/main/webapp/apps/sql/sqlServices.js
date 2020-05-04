services.factory('SQLFactory', function ($resource) {
    return $resource('/ngdemo/mysql/rest/mysql/demo', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});