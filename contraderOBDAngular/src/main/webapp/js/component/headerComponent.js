app.component("headerComponent", {
    templateUrl: 'html/header.html',
    controller: function ($scope, loginService, $location) {
        $scope.logout = function () {
            loginService.logout();
            $location.path("/");
        }
    }
})