app.controller('guasti', function ($scope, $http, userService) {

    $scope.user = userService;

    var nomeChiamata = "getGuasti";

    var parametroName = "id";
    var contenuto = $scope.user.getUser().id;

    console.log(contenuto);

    // var contenuto = $scope.user.getUser().officina.id;

    var url = 'http://localhost:8080/' + nomeChiamata + '?' + parametroName + '=' + contenuto;

    $http.post(url).
        then(function (response) {
            $scope.risposta = response.data;
        });
});