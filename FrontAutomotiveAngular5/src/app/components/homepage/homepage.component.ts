import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private loginService:LoginService,private router:Router) {}

  ngOnInit() {
    if (!this.loginService.isLogged()) {
      this.router.navigate(["login"]);
    }
  }

}
