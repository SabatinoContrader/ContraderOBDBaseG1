app.controller("homePage", function($scope,$cookies){
let user  =   $cookies.get("user");
console.log(user.cognome);
});
