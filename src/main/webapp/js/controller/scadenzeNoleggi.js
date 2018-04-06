app.controller('scadenzeNoleggi', function($scope, $http, userService) {
    
    $scope.user = userService;

    var nomeChiamata;

    var parametroName = "id";

    var contenuto;

    if($scope.user.getUser().ruolo == 0){
        contenuto =  $scope.user.getUser().id;
        nomeChiamata = "kmInScadenzaCliente";
    } 
    else {
        contenuto = $scope.user.getUser().officina.id;
        nomeChiamata = "kmInScadenzaOfficina";
    }

    console.log(contenuto);
    
	var url = 'http://localhost:8080/'+nomeChiamata+'?'+parametroName+'='+contenuto;
	
    $http.post(url).
        then(function(response) {
            $scope.risposta = response.data;
        });
});