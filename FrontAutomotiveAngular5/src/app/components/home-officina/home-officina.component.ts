import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { LoginEntity } from '../../models/LoginEntity';
import { Officina } from '../../models/Officina';
import { OfficinaService } from '../../services/officina.service';
import { Router} from '@angular/router';
import { AppRoutingModule } from '../../app-routing.module';
import { TopbarComponent } from '../topbar/topbar.component';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

const now = new Date();


@Component({
	providers:[TopbarComponent],
  selector: 'app-home-officina',
  templateUrl: './home-officina.component.html',
  styleUrls: ['./home-officina.component.css']
})
export class HomeOfficinaComponent implements OnInit {

	 officina: Officina;
	auto:any;
	utente:LoginEntity;
	scadenzaAssicurazioneadd: NgbDateStruct;
	//date:{}={year: number, month: number};
  
  constructor(private topbar:TopbarComponent,private loginService:LoginService, private officinaService:OfficinaService,private router:Router) {

  }
	

 ngOnInit() {
	 
	 
	 
    if (this.loginService.isLogged()) {
		this.utente=JSON.parse(sessionStorage.getItem("loginEntity"));
	if(this.utente.utente.ruolo==1){
		this.topbar.ngOnInit();
      this.router.navigate(["homeofficina"]);
	  this.auto=this.utente.statoAuto;
	 console.log(this.auto);
	}
  else
	  if(JSON.parse(sessionStorage.getItem("loginEntity")).utente.ruolo==0)
      this.router.navigate(["homeutente"]);
    }else{
		this.router.navigate(["login"]);
		
	}
  }

  
  

}
