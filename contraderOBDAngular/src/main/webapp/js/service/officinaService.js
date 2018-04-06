app.service('officinaService', function ($http) {
    return {
        countAll: function (callback) {
            $http({
                method: 'POST',
                url: '/countAllOfficina'
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
                url: '/listOfficina'
            }).then(function successCallback(response) {
                if(callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
    };
})