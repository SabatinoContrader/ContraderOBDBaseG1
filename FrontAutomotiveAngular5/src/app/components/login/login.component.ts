import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { LoginEntity } from '../../models/LoginEntity';
import { Router } from '@angular/router';
import { HomeOfficinaComponent } from '../../components/home-officina/home-officina.component';
import { AppRoutingModule } from '../../app-routing.module';
import swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string;
  password: string;
  loginEntity: LoginEntity;


  constructor(private loginService: LoginService, private router: Router) { }


  ngOnInit() {
    if (this.loginService.isLogged()) {

      if (JSON.parse(sessionStorage.getItem("loginEntity")).utente.ruolo == 1)
        this.router.navigate(["homeofficina"]);
      else
        if (JSON.parse(sessionStorage.getItem("loginEntity")).utente.ruolo == 0)
          this.router.navigate(["homeutente"]);
    }
  }


  login(): void {
    this.loginService.login(this.email, this.password).subscribe(
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
          console.log(this.loginEntity)
        }else{
          swal("Error","Wrong username or password","error")
        }
      },
      err => {
        swal("Error","Something goes wrong","error")
        console.log("Error occured");
      })
  }
}
