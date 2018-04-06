app.service('userService', function (userREST,$location,$cookies) {
 let parent = this
  return{
	  userObj: {},
	  userAuto:[],
	  numAlert:{},
	  userPreventivi:[],
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
		parent.numAlert=response.numAlerts;
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
		userREST.preventivi(params).$promise.then(function(response){
			
			 if(response.data!=null){
				 parent.userPreventivi=response.data;
				callback(response);
			//	  $location.path("/preventivi");
			 }
		});
	},
	 getAuto: function(){return parent.userAuto;},
	 getUser: function() {return parent.userObj;},
	 getUserPreventivi: function(){return parent.userPreventivi;},
	 getNumAlerts: function(){return parent.numAlert;}
  }
});