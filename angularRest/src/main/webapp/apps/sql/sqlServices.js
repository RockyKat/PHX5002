//set this back to /ngdemo/rest/mysql/demo to print PHXSQL table.
services.factory('SQLFactory', function ($resource) {
    return $resource('/ngdemo/rest/swap/delete/21', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});