import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { LoginEntity } from '../../models/LoginEntity';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private loginService:LoginService, private router:Router) { }


  userIsLogged():boolean{
    return this.loginService.isLogged();
  }

  getRuolo():number{
    return JSON.parse(sessionStorage.getItem("loginEntity")).utente.ruolo
  }

  logOut():void{
    sessionStorage.clear();
    this.router.navigate(["/"]);
  };
  ngOnInit() {

  }

}
