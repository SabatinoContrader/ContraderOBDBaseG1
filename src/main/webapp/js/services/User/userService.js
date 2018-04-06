app.service('userService', function (userREST,$location,$cookies) {
 let parent = this
  return{
	  userObj: {},
	  userAuto:[],
	  numGuasti:{},
	  numScadenze:{},
	  numKmNoleggio:{},
	  userPreventivi:[],
	   userAppuntamenti:[],
	   userScadenzeAuto:[],
        doLogin: function(params, callback){
		
     
      userREST.login(params).$promise.then(function(response){
		  if(response.utente!=null){
//        if(callback !=null){
         // callback(response);
		 parent.userObj= response.utente;
		// console.log(response);
		 let now = new Date(),
            exp = new Date(now.getFullYear(), now.getMonth(), now.getDate()+1);  // this will set the expiration to 1 day
         /* $cookies.put('user', userObj, { expires: exp });
          let n = $cookies.get('user');
       console.log("UTENTE COOKIE: "+n.cognome);
		  console.log("UTENTE: "+response.utente.cognome);*/
		
		  parent.userAuto=response.listaAuto;
		parent.numGuasti=response.numGuasti;
		parent.numScadenze=response.numScadenze;
		parent.numKmNoleggio=response.numKmNoleggio;
		  $location.path("/home");
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
	preventivi : function(params,callback){
		
		if(parent.userObj.ruolo==0){
		userREST.preventivi(params).$promise.then(function(response){
			
			 if(response.data!=null){
				 parent.userPreventivi=response.data;
				callback(response);
			//	  $location.path("/preventivi");
			 }
		});
		}else{
			userREST.preventiviofficina(params).$promise.then(function(response){
			
			 if(response.data!=null){
				 parent.userPreventivi=response.data;
				callback(response);
			//	  $location.path("/preventivi");
			 }
		});
		}
	},
	appuntamenti : function(params,callback){
		userREST.appuntamenti(params).$promise.then(function(response){
			
			 if(response.data!=null){
				 parent.userAppuntamenti=response.data;
				callback(response);
			//	  $location.path("/preventivi");
			 }
		});
	},
	scadenze : function(params,callback){
		userREST.scadenze(params).$promise.then(function(response){
			
			 if(response.data!=null){
				 parent.userScadenzeAuto=response.data;
				callback(response);
			//	  $location.path("/preventivi");
			 }
		});
	},
	 getAuto: function(){return parent.userAuto;},

	
	 getUserPreventivi: function(){return parent.userPreventivi;},
	 getUserAppuntamenti: function(){return parent.userAppuntamenti;},
	 getUserScadenzeAuto: function(){return parent.userScadenzeAuto;},
	 getUser() {return parent.userObj;},
	 getNumAlerts: function(){return parent.numGuasti+parent.numScadenze+parent.numKmNoleggio;},
	 getNumGuasti: function(){return parent.numGuasti;},
	 getNumScadenze: function(){return parent.numScadenze;},
	 getNumKmNoleggio: function(){return parent.numKmNoleggio;}
	 
  }
});