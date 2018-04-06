app.component("homeComponent", {
    templateUrl: 'html/home.html',
        controller: function(loginService) {
            console.log(loginService.getUsername());
            
        }

})