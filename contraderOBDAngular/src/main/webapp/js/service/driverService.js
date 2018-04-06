app.service('driverService', function ($http) {
    return {
        countAll: function (callback) {
            $http({
                method: 'POST',
                url: '/countAllDriver'
            }).then(function successCallback(response) {
                if(callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
        countDriverAzienda: function (params, callback) {
            $http({
                method: 'POST',
                url: '/countDriverAzienda',
                params: params
            }).then(function successCallback(response) {
                if (callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
        listAutoDriver: function (params, callback) {
            $http({
                method: 'POST',
                url: '/listAutoDriver',
                params: params
            }).then(function successCallback(response) {
                if (callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        }
    };
})