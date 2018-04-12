import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
<<<<<<< HEAD
import { Router } from '@angular/router';
=======
import { LoginEntity } from '../../models/LoginEntity';
>>>>>>> cfc78576b38d19b7e93f334c5e1ab98eea76670b

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

<<<<<<< HEAD
  constructor(private loginService:LoginService, private router:Router) { }
=======
  utente: LoginEntity = JSON.parse(sessionStorage.getItem("loginEntity")).utente;

  constructor(private loginService:LoginService) { }
>>>>>>> cfc78576b38d19b7e93f334c5e1ab98eea76670b

  userIsLogged():boolean{
    return this.loginService.isLogged();
  }
  logOut():void{
    sessionStorage.clear();
    this.router.navigate(["/"]);
  };
  ngOnInit() {
  }

}
