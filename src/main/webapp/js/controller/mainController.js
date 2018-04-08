app.controller("mainController", function ($scope, userService, $location, $log, $window) {

	$scope.user = userService;
	
	var page = $window.sessionStorage.getItem("page");


	/*
	$scope.email = "caio";
	$scope.pwd ="password";*/
	this.email = $scope.email;
	this.pwd = $scope.pwd;
	this.user = $scope.user;
	var email = $window.sessionStorage.getItem("email");
	var password = $window.sessionStorage.getItem("password");
	if (email && password) {
		userService.doLogin({
			email: email,
			pwd: password
		},
			function (response) {
				if (response) {
					if (page) {
						$location.path(""+page)
					}
				}
			});
	}



	$scope.preventivi = function () {
		let id;
		if (this.user.getUser().ruolo == 0) {
			id = this.user.getUser().id;
		}
		else {
			id = this.user.getUser().officina.id;
		}
		userService.preventivi({
			id: id
		}, function (response) {
			$location.path("/preventivi");


		});
	}

	$scope.appuntamenti = function () {
		let id;
		if (this.user.getUser().ruolo == 0) {
			id = this.user.getUser().id;
		}
		else {
			id = this.user.getUser().officina.id;
		}
		userService.appuntamenti({
			id: id
		}, function (response) {
			$location.path("/appuntamenti");


		});
	}

	$scope.scadenze = function () {

		userService.scadenze({
			id: this.user.getUser().id
		}, function (response) {
			$location.path("/scadenze");


		});
	}


	$scope.scadenzeNoleggi = function () {
		let id;

		if (this.user.getUser().ruolo == 0) {
			userService.scadenzeNoleggi({
				id: this.user.getUser().id
			}, function (response) {
				$location.path("/scadenzeNoleggi");

			});
		}
		else {

			userService.scadenzeNoleggiOfficina({
				id: this.user.getUser().officina.id
			}, function (response) {
				$location.path("/scadenzeNoleggi");


			});
		}

	}

	$scope.clienti = function () {

		userService.clienti({
			id: this.user.getUser().officina.id
		}, function (response) {
			$location.path("/clienti");


		});
	}

	$scope.dispositivi = function () {

		userService.dispositivi({
			idOfficina: this.user.getUser().officina.id
		}, function (response) {
			$location.path("/dispositivi");


		});
	}

	$scope.inviaRichiestaPreventivo = function (a, b) {

		userService.inviaRichiestaPreventivo({
			email: this.user.getUser().email,
			idauto: a,
			dettagli: b
		}, function (response) {
			$('#modalrichiedipreventivo').modal("hide");
			swal("Complimenti!", "Richiesta di preventivo inviata correttamente", "success");
			$location.path("/home");


		});
	}

	$scope.openmodalnoleggio = function () {
		userService.getNoleggiOfficina({
			id: this.user.getUser().officina.id
		}, function (response) {

			console.log(response.data);
			$scope.autonoleggio = response.data;
			$('#modalnoleggioauto').modal("show");
		});

	}

	$scope.inviaRichiestaNoleggio = function (a, b, c, d, e) {

		userService.inviaRichiestaNoleggio({
			idOfficina: this.user.getUser().officina.id,
			idAuto: a,
			CapLuogoDiRiconsegna: c,
			CapLuogoDiRitiro: b,
			DataInizioNoleggio: d,
			DataFineNoleggio: e,
			idUtente: this.user.getUser().id
		}, function (response) {
			$('#modalrichiedipreventivo').modal("hide");
			swal("Complimenti!", "Richiesta di preventivo inviata correttamente", "success");
			$location.path("/home");


		});
	}

	$scope.noleggi = function () {
		userService.getNoleggiOfficina({
			id: this.user.getUser().officina.id
		}, function (response) {
			$location.path("/noleggi");
		});

	}

	$scope.rispondiAppuntamento = function (a, b, c) {

		userService.rispondiAppuntamento({
			email: this.user.getUser().email,
			idapp: c,
			dettagliapp: a,
			selectapp: b,
		}, function (response) {
			$('#modalrispondiappuntamento').modal("hide");
			swal("Complimenti!", "Risposta inviata correttamente", "success");
			$location.path("/home");


		});
	}

	$scope.inviaRichiestaAppuntamento = function (a, b, c) {

		userService.inviaRichiestaAppuntamento({
			email: this.user.getUser().email,
			dettagliapp: b,
			data: a,
			ora: c

		}, function (response) {
			$('#modalrichiediappuntamento').modal("hide");
			swal("Complimenti!", "Richiesta inviata correttamente", "success");
			$location.path("/home");


		});
	}

	$scope.aggiungiCliente = function (a, b, c, d, e) {

		userService.aggiungiCliente({
			cognome: b,
			nome: a,
			email: c,
			password: d,
			idOfficina:this.user.getUser().officina.id,
			telefono:e
		}, function (response) {
			$('#modalaggiungiutente').modal("hide");
			swal("Complimenti!", "Cliente aggiunto correttamente", "success");
			$location.path("/home");


		});
	}

	$scope.aggiungiAuto = function (a, b, c, d, e,f,g,h,i,l,m,n,o) {

		userService.aggiungiAuto({
			marca: a,
			modello: b,
			targa: c,
			numeroTelaio: d,
			cilindrata: e,
			tipologiaAuto: f,
			alimentazione: g,
			numeroPorte: h,
			kmAttuali:i,
			idOfficina:this.user.getUser().officina.id,
			scadenzaAssicurazione:l,
			scadenzaBollo:m,
			scadenzaRevisione:n,
			scadenzaTagliando:o
		}, function (response) {
			$('#modaladdauto').modal("hide");
			swal("Complimenti!", "Auto aggiunta correttamente", "success");
			var email = $window.sessionStorage.getItem("email");
	var password = $window.sessionStorage.getItem("password");
	if (email && password) {
		userService.doLogin({
			email: email,
			pwd: password
		},
			function (response) {
				if (response) {
					if (page) {
						$location.path(""+page)
					}
				}
			});
	}
		//	$location.path("/");

		});
	}	
	
		$scope.aggiungiDispositivo = function (a) {

		userService.aggiungiDispositivo({
			codice: a,
			idOfficina:this.user.getUser().officina.id
			
		}, function (response) {
			$('#modaladddispositivo').modal("hide");
			swal("Complimenti!", "Dispositivo aggiunto correttamente", "success");
			$location.path("/home");


		});
	}

	
	$scope.associaDispositivo = function (a,b) {
		
		userService.associaDispositivo({
			idDispositivo: a,
			idAuto:b
		}, function (response) {

$('#modalassociadispositivo').modal("hide");
			swal("Complimenti!", "Dispositivo associato correttamente", "success");
			$location.path("/home");
			
	
		});

	}

	
	$scope.logOut = function () {
		userService.logOut();
		$window.sessionStorage.clear();
		$location.path("/");
	}

	$scope.$on('$locationChangeStart', function (event, next, current) {

		$window.sessionStorage.setItem("page", $location.path());
		if (!userService.getLogged()) {
			$location.path("/");
		}
	});
});
