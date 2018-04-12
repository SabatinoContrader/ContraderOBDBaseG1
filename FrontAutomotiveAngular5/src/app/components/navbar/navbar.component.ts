import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { LoginEntity } from '../../models/LoginEntity';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  utente: LoginEntity = JSON.parse(sessionStorage.getItem("loginEntity")).utente;

  constructor(private loginService:LoginService) { }

  userIsLogged():boolean{
    return this.loginService.isLogged();
  }

  ngOnInit() {
  }

}
