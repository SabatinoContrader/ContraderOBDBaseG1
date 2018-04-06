app.service('loginService', function ($http) {
    return {
        user : {},

        login: function (params, callback) {
            $http({
                method: 'POST',
                url: '/login',
                params: params
            }).then(function successCallback(response) {
                if (callback) {
                    callback(response);
                }
            }, function errorCallback(response) {
            });
        },
        init: function (user) {
            let parent = this;
            this.user = user;
        },
        getUsername: function () {
            return this.user.username;
        },
        getRuolo: function () {
            return this.user.ruolo;
        },
        getId: function () {
            return this.user.id;
        },
        logout: function () {
            this.user = {};
        }
    };
})