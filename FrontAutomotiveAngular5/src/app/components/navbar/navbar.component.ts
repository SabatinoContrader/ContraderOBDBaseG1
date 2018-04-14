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
  ngOnInit() {

  }

}
