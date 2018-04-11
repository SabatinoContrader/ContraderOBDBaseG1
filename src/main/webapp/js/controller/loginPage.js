app.controller("loginPage", function($scope,userService,$window,$location){

$scope.doLogin = function(){
	userService.doLogin({
      email: $scope.email,
      pwd: $scope.pwd
    },
  function(response){debugger;
    if(response){
      $window.sessionStorage.setItem("email",  response.utente.email);
      $window.sessionStorage.setItem("password", response.utente.password);
      $location.path("/home");
    }
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
console.log(response);
    });
	}

});
