app.controller("loginController", function ($scope, $http, loginService, $location) {
    $scope.login = function () {
        loginService.login({
            username: $scope.username,
            password: $scope.password
        }, function (response) {
            if (response.data.statusCode == 1) {
                alert("login errata");
                $location.path("/");
            } else if (response.data.statusCode == 0) {
                loginService.init(response.data.data);
                $location.path("/home");
            }
        }
        );
    }
})