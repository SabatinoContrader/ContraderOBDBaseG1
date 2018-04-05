app.service('userService', function (userREST,$location) {
 
  return{
	  userObj: {},
	  
        doLogin: function(params, callback){
		
      let parent = this;
      userREST.login(params).$promise.then(function(response){
		  if(response.utente!=null){
//        if(callback !=null){
         // callback(response);
		 userObj= response.utente;
		  $location.path("/home");
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
    }
  }
});