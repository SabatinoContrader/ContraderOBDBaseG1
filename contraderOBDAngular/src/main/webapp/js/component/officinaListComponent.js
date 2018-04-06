app.component("officinaListComponent", {
    templateUrl: 'html/officinaList.html',
        controller: function($scope, officinaService) {

            officinaService.listAll(function (response) {
                if (response != null) {
                    $scope.listOfficina = response.data.data;
                }
            });
            
        }

})