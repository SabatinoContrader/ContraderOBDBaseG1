import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { LoginEntity } from '../../models/LoginEntity';
import {Router} from '@angular/router';
import { HomeOfficinaComponent } from '../../components/home-officina/home-officina.component';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string;
  password: string;
  loginEntity:LoginEntity;

  constructor(private loginService:LoginService, private router:Router) { }

  ngOnInit() {
  }

  login():void{
	
    this.loginService.login(this.email,this.password).subscribe(
      (response)=> {
          if(response){
			  
            this.loginEntity = response;
			
			if(this.loginEntity.utente.ruolo==1)	this.router.navigate(['homeofficina']); 
            console.log(this.loginEntity)
          }
      },
      err => {
        console.log("Error occured");
      })
  }

}
