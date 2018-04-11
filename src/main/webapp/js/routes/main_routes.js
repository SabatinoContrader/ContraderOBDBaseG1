/*app.controller("checkUserLogged", function($scope, $location, $cookies){
  console.log("user is logged è:" + $scope.user.isLogged())
  if(!$scope.user.isLogged())
  $location.path("/");
  else {
    let page = $location.path();
    page = page.substr(1);
    if (page  == $cookies.get("page")) {
      $location.path(page);
    }
    $cookies.put("page", page);
  }
});

app.controller("refreshPage", function(userService, $location, $scope, $cookies){
  let page = $location.path();
  page =  page.substr(1);
  if(page == $cookies.get("page")){
    $location.path(page);
  }
  else {
    $cookies.put("page", page);
  }
});

app.config([
  '$provide',
  function($provide) {
    $provide.decorator('$log', [
      '$delegate',
      function logDecorator($delegate) {
        let myLog = {
          warn: function(msg) {
            log(msg, 'warn');
          },
          error: function(msg) {
            log(msg, 'error');
          },
          info: function(msg) {
            log(msg, 'info');
          },
          debug: function(msg) {
            log(msg, 'debug');
          },
          log: function(msg) {
            log(msg, 'log');
          },
          stack: []
        };

        function log(msg, type) {
          myLog.stack.push({ type: type, message: msg.toString() });
          if (console && console[type]) console[type](msg);
        }
        return myLog;
      }
    ])
  }
]);
*/
app.config(function($routeProvider){
  $routeProvider
  .when('/', {
    templateUrl: 'html/login.html'
  }) .when('/home', {
    templateUrl: 'html/home.html'
 
  }).when('/preventivi', {
    templateUrl: 'html/preventivi.html'
 
  }).when('/appuntamenti', {
    templateUrl: 'html/appuntamenti.html'
 
  })
  .when('/scadenze', {
    templateUrl: 'html/scadenze.html'
 
  })
  
  
  //Prova
  .when('/guasti', {
    templateUrl: 'html/guasti.html'
 
  })
  .when('/scadenzeNoleggi', {
    templateUrl: 'html/scadenzeNoleggi.html'
 
  }).when('/clienti', {
    templateUrl: 'html/clienti.html'
 
  }).when('/dispositivi', {
    templateUrl: 'html/dispositivi.html'
 
  }).when('/noleggi', {
    templateUrl: 'html/noleggi.html'
 
  })
  .when('/ticket', {
    templateUrl: 'html/ticket.html'
 
  })
  
  
});
