app.controller('guasti', function ($scope, $http, userService) {

	userService.guasti({
        id: userService.getUser().id
    }, function (response) {
        $location.path("/guasti");


    });
});