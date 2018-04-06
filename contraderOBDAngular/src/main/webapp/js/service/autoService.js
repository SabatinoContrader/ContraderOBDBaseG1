app.service('autoService', function ($http) {
    return {
        obj: {},
        countAll: function (callback) {
            $http({
                method: 'POST',
                url: '/countAllAuto'
            }).then(function successCallback(response) {
                if(callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
        countAutoAzienda: function (params, callback) {
            $http({
                method: 'POST',
                url: '/countAutoAzienda',
                params: params
            }).then(function successCallback(response) {
                if (callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
        countAutoAziendaError: function (params, callback) {
            $http({
                method: 'POST',
                url: '/countAutoAziendaError',
                params: params
            }).then(function successCallback(response) {
                if (callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
        findAuto: function (params, callback) {
            $http({
                method: 'POST',
                url: '/findAuto',
                params: params
            }).then(function successCallback(response) {
                if (callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
        salvaRisposta: function (obj) {
            this.obj = obj;
        },
        getRisposta: function () {
            return this.obj;
        }
    };
})