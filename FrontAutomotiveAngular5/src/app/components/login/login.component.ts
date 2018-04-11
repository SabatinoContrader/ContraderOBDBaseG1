import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { LoginEntity } from '../../models/LoginEntity';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string;
  password: string;
  loginEntity:LoginEntity;

  constructor(private loginService:LoginService) { }

  ngOnInit() {
  }

  login():void{
    this.loginService.login(this.email,this.password).subscribe(
      (response)=> {
          if(response){
            this.loginEntity = response;
            console.log(this.loginEntity)
          }
      },
      err => {
        console.log("Error occured");
      })
  }

}
