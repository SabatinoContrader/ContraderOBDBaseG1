app.controller('guasti', function ($scope, userService,$location) {
	
	$scope.setGuastoRisolto = function (a) {
		
		userService.setGuastoRisolto({
			idGuasto: a
		}, function (response) {

		$('#modalsetguastorisolto').modal("hide");
			swal("Complimenti!", "Guasto risolto correttamente", "success");
			$location.path("/home");
			
	
		});

	},
	userService.guasti({
        id: userService.getUser().id
    }, function (response) {
       

    });
	
	
	
});