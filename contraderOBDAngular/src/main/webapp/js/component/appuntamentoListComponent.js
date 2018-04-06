app.component("appuntamentoListComponent", {
    templateUrl: 'html/appuntamentoList.html',
        controller: function($scope, loginService, appuntamentoService) {
            $scope.id = loginService.getId();
            $scope.ruolo = loginService.getRuolo();
            appuntamentoService.listById({
                id: $scope.id,
                ruolo: $scope.ruolo
            }, function (response) {
                if (response != null) {
                    $scope.listAppuntamento = response.data.data;
                }
            });
            
        }

})