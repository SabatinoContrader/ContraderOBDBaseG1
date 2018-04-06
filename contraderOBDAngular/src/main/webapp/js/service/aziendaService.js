app.service('aziendaService', function ($http) {
    return {
        countAll: function (callback) {
            $http({
                method: 'POST',
                url: '/countAllAzienda'
            }).then(function successCallback(response) {
                if(callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
        listAll: function (callback) {
            $http({
                method: 'POST',
                url: '/listAzienda'
            }).then(function successCallback(response) {
                if(callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
    };
})