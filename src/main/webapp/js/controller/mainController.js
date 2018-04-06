app.controller("mainController", function($scope, userService, $location, $log, $cookies){

  $scope.user = userService;
  
/*
$scope.email = "caio";
$scope.pwd ="password";*/
this.email = $scope.email;
this.pwd =$scope.pwd;
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

});
