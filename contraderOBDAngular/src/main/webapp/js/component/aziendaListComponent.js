app.component("aziendaListComponent", {
    templateUrl: 'html/aziendaList.html',
        controller: function($scope, aziendaService) {

            aziendaService.listAll(function (response) {
                if (response != null) {
                    $scope.listAzienda = response.data.data;
                }
            });
            
        }

})