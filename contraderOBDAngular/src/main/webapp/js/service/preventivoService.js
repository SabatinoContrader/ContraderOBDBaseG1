app.service('preventivoService', function ($http) {
    return {
        countAllOfficina: function (params,callback) {
            $http({
                method: 'POST',
                url: '/countPreventivoOfficina',
                params: params
            }).then(function successCallback(response) {
                if(callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
        listById: function (params, callback) {
            $http({
                method: 'POST',
                url: '/listPreventivo',
                params: params
            }).then(function successCallback(response) {
                if(callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        }
    };
})