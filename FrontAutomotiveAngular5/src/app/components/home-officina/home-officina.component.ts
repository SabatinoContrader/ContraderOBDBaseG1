import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { LoginEntity } from '../../models/LoginEntity';
import { Officina } from '../../models/Officina';
import { OfficinaService } from '../../services/officina.service';
import { Router} from '@angular/router';
import { AppRoutingModule } from '../../app-routing.module';

@Component({
  selector: 'app-home-officina',
  templateUrl: './home-officina.component.html',
  styleUrls: ['./home-officina.component.css']
})
export class HomeOfficinaComponent implements OnInit {

	 officina: Officina;
	auto:any;
  constructor(private loginService:LoginService, private officinaService:OfficinaService,private router:Router) {

  }

 ngOnInit() {
	 
	 
    if (this.loginService.isLogged()) {
	if(JSON.parse(sessionStorage.getItem("loginEntity")).utente.ruolo==1){
      this.router.navigate(["homeofficina"]);
	  this.auto=JSON.parse(sessionStorage.getItem("loginEntity")).listaAuto;
	 console.log(this.auto);
	}
  else
	  if(JSON.parse(sessionStorage.getItem("loginEntity")).utente.ruolo==0)
      this.router.navigate(["homeutente"]);
    }
  }

  
  

}
