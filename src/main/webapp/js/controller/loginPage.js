app.controller("loginPage", function($scope,userService){
$scope.email = "caio";
$scope.pwd ="password";
$scope.doLogin = function(){
	userService.doLogin({
      email: $scope.email,
      pwd: $scope.pwd
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
console.log(response);
    });
	}

});
