app.service('userService', function (userREST, $location, $cookies) {
	let parent = this
	return {
		userObj: {},
		userAuto: [],
		numGuasti: {},
		numScadenze: {},
		numKmNoleggio: {},
		userPreventivi: [],
		userAppuntamenti: [],
		userScadenzeAuto: [],
		userClienti: [],
		userGuasti: [],
		scadenzeNoleggi: [],
		userDispositivi: [],
		userNoleggi: [],
		userTicket:[],
		isLogged: false,
		doLogin: function (params, callback) {


			userREST.login(params).$promise.then(function (response) {
				if (response.utente != null) {
					if (callback) {
						callback(response);
					}
					//        if(callback !=null){
					// callback(response);
					parent.userObj = response.utente;
					parent.isLogged = true;
					// console.log(response);
					let now = new Date(),
						exp = new Date(now.getFullYear(), now.getMonth(), now.getDate() + 1);  // this will set the expiration to 1 day
					/* $cookies.put('user', userObj, { expires: exp });
					 let n = $cookies.get('user');
				  console.log("UTENTE COOKIE: "+n.cognome);
					 console.log("UTENTE: "+response.utente.cognome);*/

					parent.userAuto = response.listaAuto;
					parent.numGuasti = response.numGuasti;
					parent.numScadenze = response.numScadenze;
					parent.numKmNoleggio = response.numKmNoleggio;

					$('#headercontent').show();
					$("#wrapper").toggleClass("toggled");

				}
				else {
					/*if(data.statusCode==0){
					  $log.debug("userService.doLogin silent| statusCode is 0");
					}
					else {
					  $log.warn("userService.doLogin silent| error");
					  $log.warn("userService.doLogin silent| " + response.statusCode);
					}*/
					alert("ERRORE");
				}
			});
		},
		preventivi: function (params, callback) {

			if (parent.userObj.ruolo == 0) {
				userREST.preventivi(params).$promise.then(function (response) {

					if (response.data != null) {
						parent.userPreventivi = response.data;
						callback(response);
						//	  $location.path("/preventivi");
					}
				});
			} else {
				userREST.preventiviofficina(params).$promise.then(function (response) {

					if (response.data != null) {
						parent.userPreventivi = response.data;
						callback(response);
						//	  $location.path("/preventivi");
					}
				});
			}
		},
		appuntamenti: function (params, callback) {
			if (parent.userObj.ruolo == 0) {
				userREST.appuntamenti(params).$promise.then(function (response) {

					if (response.data != null) {
						parent.userAppuntamenti = response.data;
						callback(response);
						//	  $location.path("/preventivi");
					}
				});
			} else {
				userREST.appuntamentiofficina(params).$promise.then(function (response) {

					if (response.data != null) {
						parent.userAppuntamenti = response.data;
						console.log(parent.userAppuntamenti);
						callback(response);
						//	  $location.path("/preventivi");
					}
				});
			}
		},
		scadenze: function (params, callback) {
			userREST.scadenze(params).$promise.then(function (response) {

				if (response.data != null) {
					parent.userScadenzeAuto = response.data;
					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		guasti: function (params, callback) {
			userREST.guasti(params).$promise.then(function (response) {

				if (response.data != null) {
					parent.userGuasti = response.data;
					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		scadenzeNoleggi: function (params, callback) {
			userREST.scadenzeNoleggi(params).$promise.then(function (response) {

				if (response.data != null) {
					parent.scadenzeNoleggi = response.data;
					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		scadenzeNoleggiOfficina: function (params, callback) {
			userREST.scadenzeNoleggiOfficina(params).$promise.then(function (response) {

				if (response.data != null) {
					parent.scadenzeNoleggi = response.data;
					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		clienti: function (params, callback) {
			userREST.clienti(params).$promise.then(function (response) {

				if (response.data != null) {

					parent.userClienti = response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		getClientiOfficina: function (params, callback) {
			userREST.getClientiOfficina(params).$promise.then(function (response) {

				if (response.data != null) {

					parent.userClienti = response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		dispositivi: function (params, callback) {
			userREST.dispositivi(params).$promise.then(function (response) {

				if (response.data != null) {

					parent.userDispositivi = response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		openmodalassociadispositivo: function (params, callback) {
			userREST.openmodalassociadispositivo(params).$promise.then(function (response) {

				if (response.data != null) {

					parent.userDispositivi = response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		inviaRichiestaPreventivo: function (params, callback) {
			userREST.inviaRichiestaPreventivo(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		getNoleggiOfficina: function (params, callback) {
			userREST.getNoleggiOfficina(params).$promise.then(function (response) {
				parent.userNoleggi = response.data;
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;


					//	  $location.path("/preventivi");
				}
			});
		},
		inviaRichiestaNoleggio: function (params, callback) {
			userREST.inviaRichiestaNoleggio(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		rispondiAppuntamento: function (params, callback) {

			userREST.rispondiAppuntamento(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		inviaRichiestaAppuntamento: function (params, callback) {
			userREST.inviaRichiestaAppuntamento(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		aggiungiCliente: function (params, callback) {
			userREST.aggiungiCliente(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		aggiungiAuto: function (params, callback) {
			userREST.aggiungiAuto(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		aggiungiDispositivo: function (params, callback) {
			userREST.aggiungiDispositivo(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		associaDispositivo: function (params, callback) {
			userREST.associaDispositivo(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		setGuastoRisolto: function (params, callback) {
			userREST.setGuastoRisolto(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		statoPreventivo: function (params, callback) {
			userREST.statoPreventivo(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		inviaRispostaPreventivo: function (params, callback) {
			userREST.inviaRispostaPreventivo(params).$promise.then(function (response) {
				callback(response);
				if (response.data != null) {

					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		ticket: function (params, callback) {
			userREST.ticket(params).$promise.then(function (response) {debugger;
				parent.userTicket=response.data;
					
				if (response.data != null) {
					
					//	 parent.userDispositivi=response.data;

					callback(response);
					//	  $location.path("/preventivi");
				}
			});
		},
		
		getUserTicket: function(){return parent.userTicket;},
		getUserNoleggi: function () { return parent.userNoleggi; },
		getUserDispositivi: function () { return parent.userDispositivi; },
		getUserClienti: function () { return parent.userClienti; },
		getAuto: function () { return parent.userAuto; },
		getScadenzeNoleggi: function () { return parent.scadenzeNoleggi; },
		getUserGuasti: function () { return parent.userGuasti; },
		getUserPreventivi: function () { return parent.userPreventivi; },
		getUserAppuntamenti: function () { return parent.userAppuntamenti; },
		getUserScadenzeAuto: function () { return parent.userScadenzeAuto; },
		getUser() { return parent.userObj; },
		getNumAlerts: function () { return parent.numGuasti + parent.numScadenze + parent.numKmNoleggio; },
		getNumGuasti: function () { return parent.numGuasti; },
		getNumScadenze: function () { return parent.numScadenze; },
		getNumKmNoleggio: function () { return parent.numKmNoleggio; },
		getLogged: function () { return parent.isLogged },
		logOut: function () {
			parent.userObj = {};
			parent.isLogged = false;
		}

	}
});