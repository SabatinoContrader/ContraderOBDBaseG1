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
    }
	
  });
}

]);
