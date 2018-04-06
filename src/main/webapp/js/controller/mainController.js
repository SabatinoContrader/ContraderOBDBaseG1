app.controller("mainController", function($scope, userService, $location, $log, $cookies){

  $scope.user = userService;
  
/*
$scope.email = "caio";
$scope.pwd ="password";*/
this.email = $scope.email;
this.pwd =$scope.pwd;
this.user=$scope.user;
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

	$scope.preventivi = function(){
		let id;
	if(this.user.getUser().ruolo==0){
		id=this.user.getUser().id;
	}
	else{
		 id=this.user.getUser().officina.id;
	}
		userService.preventivi({
			id:id
		},function(response){
							 $location.path("/preventivi");
			
			
		});
	}
	
		$scope.appuntamenti = function(){
	
		userService.appuntamenti({
			id:this.user.getUser().id
		},function(response){
							 $location.path("/appuntamenti");
			
			
		});
	}

	$scope.scadenze = function(){
	
		userService.scadenze({
			id:this.user.getUser().id
		},function(response){
							 $location.path("/scadenze");
		
			
		});
	}
	
});
