//set this back to /ngdemo/rest/sql/demo to print PHXSQL table.
services.factory('SQLFactory', function ($resource) {
    return $resource('/ngdemo/rest/sql/demo', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});