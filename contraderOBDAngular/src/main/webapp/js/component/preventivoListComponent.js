app.component("preventivoListComponent", {
    templateUrl: 'html/preventivoList.html',
        controller: function($scope, loginService, preventivoService) {
            $scope.id = loginService.getId();
            $scope.ruolo = loginService.getRuolo();
            preventivoService.listById({
                id: $scope.id,
                ruolo: $scope.ruolo
            }, function (response) {
                if (response != null) {
                    $scope.listPreventivo = response.data.data;
                }
            });
            
        }

})