app.service('userService', function (userREST,$location,$cookies) {
 let parent = this
  return{
	  userObj: {},
	  userAuto:[],
	  numAlert:{},
        doLogin: function(params, callback){
		
     
      userREST.login(params).$promise.then(function(response){
		  if(response.utente!=null){
//        if(callback !=null){
         // callback(response);
		 userObj= response.utente;
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
	 getAuto: function(){return parent.userAuto;},
	 getUser() {return this.userObj;},
	 getNumAlerts: function(){return parent.numAlert;}
  }
});