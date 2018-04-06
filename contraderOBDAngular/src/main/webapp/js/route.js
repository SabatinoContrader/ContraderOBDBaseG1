app.config(function ($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: 'html/login.html'
    })
    .when('/home', {
        templateUrl: 'html/home.html'
    })
    .when('/viewOfficina', {
        templateUrl: 'html/viewOfficina.html'
    })
    .when('/viewAzienda', {
        templateUrl: 'html/viewAzienda.html'
    })
    .when('/viewAuto', {
        templateUrl: 'html/viewAuto.html'
    })
    .when('/viewPreventivo', {
        templateUrl: 'html/viewPreventivo.html'
    })
    .when('/viewAppuntamento', {
        templateUrl: 'html/viewAppuntamento.html'
    })
})