app.service('appuntamentoService', function ($http) {
    return {
        countAllOfficina: function (params,callback) {
            $http({
                method: 'POST',
                url: '/countAppuntamentoOfficina',
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
                url: '/listAppuntamento',
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