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
    }
  });
}

]);
