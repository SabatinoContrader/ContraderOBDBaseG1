app.factory('userREST',['$resource',
function($resource){
  var baseUrl = '/'

  return $resource(baseUrl, {},{
    signup: {
        method: 'GET',
        url: baseUrl+'registrazione',
        headers: {'Content-Type':'application/json;charset=UTF-8'}
    },
    login: {
      method: 'POST',
      url: baseUrl+'login',
      headers: {'Content-Type': 'application/json; charset=UTF-8' },
	  params:{
		  email:'@email',
		  pwd:'@pwd'
	  }
    },
    update: {
      method: 'POST',
      url: baseUrl+'update',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
      params: {
        username: '@username'
      }
    },
	 preventivi: {
      method: 'POST',
      url: baseUrl+'preventiviCliente',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        id: '@id'
      }
    },
	 preventiviofficina: {
      method: 'POST',
      url: baseUrl+'preventiviOfficina',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        id: '@id'
      }
    },
	 appuntamenti: {
      method: 'POST',
      url: baseUrl+'appuntamentiCliente',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        id: '@id'
      }
    },
	 appuntamentiofficina: {
      method: 'POST',
      url: baseUrl+'appuntamentiOfficina',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        id: '@id'
      }
	 }
	,
	 scadenze: {
      method: 'POST',
      url: baseUrl+'autoInScadenza',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        id: '@id'
      }
    },
	 guasti: {
      method: 'POST',
      url: baseUrl+'getGuasti',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        id: '@id'
      }
    },
	 scadenzeNoleggi: {
      method: 'POST',
      url: baseUrl+'kmInScadenzaCliente',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        id: '@id'
      }
    },
	 scadenzeNoleggiOfficina: {
      method: 'POST',
      url: baseUrl+'kmInScadenzaOfficina',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        id: '@id'
      }
    },
	 clienti: {
      method: 'POST',
      url: baseUrl+'clientiOfficina',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        id: '@id'
      }
    },
	 dispositivi: {
      method: 'POST',
      url: baseUrl+'listaDispositiviOfficina',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        idOfficina: '@idOfficina'
      }
    },
	 inviaRichiestaPreventivo: {
      method: 'POST',
      url: baseUrl+'inviapreventivo',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
        email: '@email',
		dettagli:'@dettagli',
		idauto:'@idauto'
      }
    },
	 getNoleggiOfficina: {
      method: 'POST',
      url: baseUrl+'noleggiOfficina',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
       id:'@id'
      }
    },
	inviaRichiestaNoleggio: {
      method: 'POST',
      url: baseUrl+'inserisciNoleggio',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
		  idOfficina: '@idOfficina',
				idAuto:'@idAuto',
				CapLuogoDiRiconsegna:'@CapLuogoDiRiconsegna',
				CapLuogoDiRitiro:'@CapLuogoDiRitiro',
				DataInizioNoleggio:'@DataInizioNoleggio',
				DataFineNoleggio:'@DataFineNoleggio',
				idUtente:'@idUtente'
      }
    },
	rispondiAppuntamento: {
      method: 'POST',
      url: baseUrl+'rispondiappuntamento',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
				emailapp:'@email',
				dettagliapp:'@dettagliapp',
				idapp:'@idapp',
				selectapp:'@selectapp'
      }
    },
	inviaRichiestaAppuntamento: {
      method: 'POST',
      url: baseUrl+'richiediappuntamento',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
				emailapp:'@email',
				dettagliapp:'@dettagliapp',
				ora:'@ora',
				dataAppuntamento:'@data'
				
      }
    },
	aggiungiCliente: {
      method: 'POST',
      url: baseUrl+'inserisciCliente',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
				
			cognome: '@cognome',
			nome: '@nome',
			email: '@email',
			password: '@password',
			idOfficina:'@idOfficina',
			telefono:'@telefono'
      }
    },
	aggiungiAuto: {
      method: 'POST',
      url: baseUrl+'inserisciAuto',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
			marca: '@marca',
			modello: '@modello',
			targa: '@targa',
			numeroTelaio: '@numeroTelaio',
			cilindrata:'@cilindrata',
			tipologiaAuto:'@tipologiaAuto',
			alimentazione: '@alimentazione',
			numeroPorte: '@numeroPorte',
			kmAttuali: '@kmAttuali',
			idOfficina: '@idOfficina',
			scadenzaAssicurazione: '@scadenzaAssicurazione',
			scadenzaBollo: '@scadenzaBollo',
			scadenzaRevisione: '@scadenzaRevisione',
			scadenzaTagliando: '@scadenzaTagliando'
      }
    },
	aggiungiDispositivo: {
      method: 'POST',
      url: baseUrl+'inserisciDispositivo',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
			idOfficina: '@idOfficina',
			codice: '@codice'
      }
    },
	associaDispositivo: {
      method: 'POST',
      url: baseUrl+'installazioneDispositivo',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
			idDispositivo: '@idDispositivo',
			idAuto:'@idAuto'
      }
	
	},
	setGuastoRisolto: {
      method: 'POST',
      url: baseUrl+'setrisoltoguasto',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
			idguasto: '@idGuasto'
      }
	
	},
	statoPreventivo: {
      method: 'POST',
      url: baseUrl+'accettapreventivo',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
			stato: '@stato',
			idprev:'@idprev'
      }
	
	},
	inviaRispostaPreventivo: {
      method: 'POST',
      url: baseUrl+'rispondipreventivo',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
			dettagli: '@dettagli',
			costoprev:'@costoprev',
			idprev:'@idprev'
      }
	
	},
	getClientiOfficina: {
      method: 'POST',
      url: baseUrl+'clientiOfficina',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
			id: '@id'
      }
	
	},
	openmodalassociadispositivo: {
      method: 'POST',
      url: baseUrl+'autoSenzaDispositivo',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
			id: '@id'
      }
	
	},
	ticket: {
      method: 'POST',
      url: baseUrl+'ticketOfficina',
      headers:{'Content-Type': 'application/json; charset=UTF-8' },
	  params: {
			id: '@id'
      }
	
	}
	
  });
}

]);
