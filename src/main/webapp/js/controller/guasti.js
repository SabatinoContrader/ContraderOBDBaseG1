app.controller('guasti', function ($scope, $http, userService, $location) {

    userService.guasti({
        id: userService.getUser().id
    }, function (response) {
    });
});