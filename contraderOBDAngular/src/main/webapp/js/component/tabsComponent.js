app.component("tabsComponent", {
    templateUrl: 'html/tabs.html',
    controller: function ($scope, $http, loginService, autoService, aziendaService, officinaService,
        preventivoService, appuntamentoService, driverService ) {

        $scope.ruolo = loginService.getRuolo();
        $scope.id = loginService.getId();
        if ($scope.ruolo == 1) {
            officinaService.countAll(function (response) {
                $scope.countOfficinaAll = response.data.data;
            });
            aziendaService.countAll(function (response) {
                $scope.countAziendaAll = response.data.data;
            });
            autoService.countAll(function (response) {
                $scope.countAutoAll = response.data.data;
            });
            driverService.countAll(function (response) {
                $scope.countDriverAll = response.data.data;
            });
        }
        if ($scope.ruolo == 2) {
            preventivoService.countAllOfficina({
                id: $scope.id
            }, function (response) {
                $scope.countPreventivoOfficina = response.data.data;
            });
            appuntamentoService.countAllOfficina({
                id: $scope.id
            }, function (response) {
                $scope.countAppuntamentoOfficina = response.data.data;
            });
        }
        if ($scope.ruolo == 3) {
            autoService.countAutoAzienda({
                id: $scope.id
            }, function (response) {
                $scope.countAutoAzienda = response.data.data;
            });
            driverService.countDriverAzienda({
                id: $scope.id
            }, function (response) {
                $scope.countDriverAzienda = response.data.data;
            });
            autoService.countAutoAziendaError({
                id: $scope.id
            }, function (response) {
                $scope.countAutoAziendaError = response.data.data;
            });
        }
        if ($scope.ruolo == 4) {
            driverService.listAutoDriver({
                id: $scope.id
            }, function (response) {
                $scope.listAutoDriver = response.data.data;
            });
            
        }
    }
})