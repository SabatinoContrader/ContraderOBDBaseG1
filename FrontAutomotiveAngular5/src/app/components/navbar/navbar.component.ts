import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { LoginEntity } from '../../models/LoginEntity';
import swal from 'sweetalert2';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private loginService:LoginService, private router:Router) { }
  loginEntity:LoginEntity;

  userIsLogged():boolean{
    return this.loginService.isLogged();
  }

  getRuolo():number{
    return JSON.parse(sessionStorage.getItem("loginEntity")).utente.ruolo
  }

  getNumeroGuasti():number{
    return JSON.parse(sessionStorage.getItem("loginEntity")).numGuasti
  }
  
  getNumeroScadenze(): number{
  return JSON.parse(sessionStorage.getItem("loginEntity")).numScadenze
  }
  
  logOut():void{
    var self = this;
    swal({
      title: 'Are you sure?',
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, exit!'
    }).then((result) => {
      if (result.value) {
        sessionStorage.clear();
        self.router.navigate(["/"]);
      }
    })
  };

  login():void{
    swal({
      title: 'Login Now',
      html:
      
    `<div>
      <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"alt="">
    </div>
    <div class="form-group row">
       <label for="example-text-input" class="col-4 col-form-label" >Username</label>
       <div class="col-8">
         <input class="form-control" type="text" id="username">
       </div>
     </div>
     <div class="form-group row">
       <label for="example-text-input" class="col-4 col-form-label" >Password</label>
       <div class="col-8">
         <input class="form-control" type="text" id="password">
       </div>
     </div>`,
      confirmButtonText: "Login",
      focusConfirm: false,
      preConfirm: function () {
        return new Promise(function (resolve) {
          resolve([
            $('#username').val(),
            $('#password').val()
          ])
        })
      }
    }).then(result=>{
      var email = result.value[0];
      var password = result.value[1];
      console.log(result)
      if(email!=null && email!="" && password!=null && password!=""){
      this.loginService.login( email, password).subscribe(
        (response) => {
          if (response.utente!=null) {
            this.loginEntity = response;
            console.log(response);
            if (typeof (Storage) !== 'undefined') {
              sessionStorage.setItem('loginEntity', JSON.stringify(this.loginEntity));
              swal("Success", "Login effettuato con successo", "success");
            }
            if (JSON.parse(sessionStorage.getItem("loginEntity")).utente.ruolo == 1)
              this.router.navigate(["homeofficina"]);
            else
              if (JSON.parse(sessionStorage.getItem("loginEntity")).utente.ruolo == 0)
                this.router.navigate(["homeutente"]);
          }else{
            swal("Error","Wrong username or password","error")
          }
        },
        err => {
          swal("Error","Something goes wrong","error")
          console.log("Error occured");
        })
      }else{
        swal("Error","Field username and password cannot be empty","error")
      }
    }).catch()
  }


  ngOnInit() {

  }

}
