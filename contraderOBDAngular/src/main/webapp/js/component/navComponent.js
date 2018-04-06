app.component("navComponent", {
    templateUrl: 'html/nav.html',
    controller: function ($scope, $http, $location, loginService, officinaService, autoService ) {
        $scope.ruolo = loginService.getRuolo();
        var self = this;
       $scope.findAutoOfficina = function () {
           autoService.findAuto({
               findAuto: self.autoToFind 
           }, function (response) {
               if (response != null) {
                   $scope.auto = response.data.data;
                   autoService.salvaRisposta($scope.auto);
                   $location.path("/viewAuto");
               }
           })
       }
    }
})