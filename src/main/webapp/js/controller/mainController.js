	app.controller("mainController", function($scope, userService, $location, $log, $cookies){

		$scope.user = userService;

		
		
	/*
	$scope.email = "caio";
	$scope.pwd ="password";*/
	this.email = $scope.email;
	this.pwd =$scope.pwd;
	this.user=$scope.user;
	$scope.doLogin = function(){
		
		userService.doLogin({
				email: this.email,
				pwd: this.pwd
			},
		function(response){
			/*if(response.statusCode==0){
				userService.init(response.data);
				$scope.user = userService;
				if(page != ""){
					$location.path("/" + page);
				}else
					$location.path("/");
				}
				else{
					$log.debug("something is wrong, i read cookies but this is the response:")
					$log.debug(response);
				}
	*/
			});
		

		}

		$scope.preventivi = function(){
			let id;
		if(this.user.getUser().ruolo==0){
			id=this.user.getUser().id;
		}
		else{
			id=this.user.getUser().officina.id;
		}
			userService.preventivi({
				id:id
			},function(response){
								$location.path("/preventivi");
				
				
			});
		}
		
			$scope.appuntamenti = function(){
		let id;
		if(this.user.getUser().ruolo==0){
			id=this.user.getUser().id;
		}
		else{
			id=this.user.getUser().officina.id;
		}
			userService.appuntamenti({
				id:id
			},function(response){
								$location.path("/appuntamenti");
				
				
			});
		}

		$scope.scadenze = function(){
		
			userService.scadenze({
				id:this.user.getUser().id
			},function(response){
								$location.path("/scadenze");
			
				
			});
		}
		
		$scope.guasti = function(){
		
			userService.guasti({
				id:this.user.getUser().id
			},function(response){
								$location.path("/guasti");
				
				
			});
		}
		
		$scope.scadenzeNoleggi = function(){
		let id;
		
		if(this.user.getUser().ruolo==0){
		userService.scadenzeNoleggi({
				id:this.user.getUser().id
			},function(response){
								$location.path("/scadenzeNoleggi");
							
			});
		}
		else{
			
			userService.scadenzeNoleggiOfficina({
				id:this.user.getUser().officina.id
			},function(response){
								$location.path("/scadenzeNoleggi");
				
				
			});
		}
			
		}
		
		$scope.clienti = function(){
		
			userService.clienti({
				id:this.user.getUser().officina.id
			},function(response){
								$location.path("/clienti");
				
				
			});
		}
		
		$scope.dispositivi = function(){
		
			userService.dispositivi({
				idOfficina:this.user.getUser().officina.id
			},function(response){
								$location.path("/dispositivi");
				
				
			});
		}
		
		$scope.inviaRichiestaPreventivo = function(a,b){
		
			userService.inviaRichiestaPreventivo({
				email:this.user.getUser().email,
				idauto:a,
				dettagli:b
			},function(response){
				$('#modalrichiedipreventivo').modal("hide");
				swal("Complimenti!", "Richiesta di preventivo inviata correttamente", "success"); 
								$location.path("/home");
				
				
			});
		}
		
		$scope.openmodalnoleggio = function(){
			userService.getNoleggiOfficina({
				id:this.user.getUser().officina.id
			},function(response){
			
				console.log(response.data);
				$scope.autonoleggio=response.data;
				$('#modalnoleggioauto').modal("show");
			});
			
		}
		
		$scope.inviaRichiestaNoleggio = function(a,b,c,d,e){
		
			userService.inviaRichiestaNoleggio({
				idOfficina: this.user.getUser().officina.id,
				idAuto:a,
				CapLuogoDiRiconsegna:c,
				CapLuogoDiRitiro:b,
				DataInizioNoleggio:d,
				DataFineNoleggio:e,
				idUtente:this.user.getUser().id
			},function(response){
				$('#modalrichiedipreventivo').modal("hide");
				swal("Complimenti!", "Richiesta di preventivo inviata correttamente", "success"); 
								$location.path("/home");
				
				
			});
		}
		
		$scope.noleggi = function(){
			userService.getNoleggiOfficina({
				id:this.user.getUser().officina.id
			},function(response){
			$location.path("/noleggi");
			});
			
		}
		
		$scope.rispondiAppuntamento = function(a,b,c){
	
			userService.rispondiAppuntamento({
				email: this.user.getUser().email,
				idapp:c,
				dettagliapp:a,
				selectapp:b,
			},function(response){
				$('#modalrispondiappuntamento').modal("hide");
				swal("Complimenti!", "Risposta inviata correttamente", "success"); 
								$location.path("/home");
				
				
			});
		}
		
		$scope.inviaRichiestaAppuntamento = function(a,b,c){
	
			userService.inviaRichiestaAppuntamento({
				email: this.user.getUser().email,
				dettagliapp:b,
				data:a,
				ora:c
				
			},function(response){
				$('#modalrichiediappuntamento').modal("hide");
				swal("Complimenti!", "Richiesta inviata correttamente", "success"); 
								$location.path("/home");
				
				
			});
		}
		
		$scope.logOut = function(){
			userService.logOut();
			$location.path("/");
		}

		$scope.$on('$locationChangeStart', function(event, next, current) {debugger;
			if(!userService.getLogged()){
				$location.path("/");
			}
	});
	});
