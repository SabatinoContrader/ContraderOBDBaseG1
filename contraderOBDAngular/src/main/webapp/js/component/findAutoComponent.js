app.component("findAutoComponent", {
    templateUrl: 'html/findAuto.html',
    controller: function ($scope, autoService) {
        $scope.auto = autoService.getRisposta();
    }

})