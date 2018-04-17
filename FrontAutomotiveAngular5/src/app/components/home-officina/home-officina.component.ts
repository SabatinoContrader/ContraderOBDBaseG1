import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { LoginEntity } from '../../models/LoginEntity';
import { AutoService } from '../../services/auto.service';
import { TelemetriaService } from '../../services/telemetria.service';
import { Auto } from '../../models/Auto';
import { Officina } from '../../models/Officina';
import { OfficinaService } from '../../services/officina.service';
import { Router} from '@angular/router';
import { AppRoutingModule } from '../../app-routing.module';
import { TopbarComponent } from '../topbar/topbar.component';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import swal from 'sweetalert2';

declare var jquery:any;
declare var $ :any;
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
	marcaautoadd;
	modelloautoadd;
	targaautoadd;
	telaioautoadd;
	alimentazioneautoadd;
	cilindrataautoadd;
	tipologiaautoadd;
	numeroporteautoadd;
	kmattualiautoadd;
	cambio;
	potenza;
	
	scadenzaAssicurazioneadd: NgbDateStruct;
	scadenzaBolloadd: NgbDateStruct;
	scadenzaTagliandoadd: NgbDateStruct;
	scadenzaRevisioneadd: NgbDateStruct;
	//date:{}={year: number, month: number};
 
  constructor(private telemetriaService: TelemetriaService,private topbar:TopbarComponent,private loginService:LoginService,private autoService:AutoService, private officinaService:OfficinaService,private router:Router) {

  }
	

	ngOnInit() {
	  
	 
    if (this.loginService.isLogged()) {
		this.utente=JSON.parse(sessionStorage.getItem("loginEntity"));
	if(this.utente.utente.ruolo==0){
		this.router.navigate(["homeutente"]);
	}else{
		this.auto=this.utente.statoAuto;
	}
 
    }else{
		this.router.navigate(["login"]);
		
	}
  }


  
  public insertAuto(){
	  this.autoService.insertAuto(this.marcaautoadd,this.modelloautoadd,this.targaautoadd,this.telaioautoadd,this.cilindrataautoadd,this.cambio,this.potenza,this.tipologiaautoadd,this.alimentazioneautoadd,this.numeroporteautoadd,this.kmattualiautoadd, this.utente.utente.officina.id,this.scadenzaAssicurazioneadd.day+"/"+this.scadenzaAssicurazioneadd.month+"/"+this.scadenzaAssicurazioneadd.year,this.scadenzaBolloadd.day+"/"+this.scadenzaBolloadd.month+"/"+this.scadenzaBolloadd.year,this.scadenzaTagliandoadd.day+"/"+this.scadenzaTagliandoadd.month+"/"+this.scadenzaTagliandoadd.year,this.scadenzaRevisioneadd.day+"/"+this.scadenzaRevisioneadd.month+"/"+this.scadenzaRevisioneadd.year).subscribe(
      (response) => {
		  this.loginService.login(this.utente.utente.email,this.utente.utente.password).subscribe(
      (response) => {
		  console.log(response);
        if (response) {

          
		  this.utente = response;
		sessionStorage.setItem('loginEntity', JSON.stringify(this.utente));
		this.auto = response.statoAuto;
		console.log(response.statoAuto);

		swal("Complimenti", "Auto inserita correttamente", "success");

           $('#modaladdauto').modal("hide");

        }
      },
      err => {
        console.log("Error occured");
      });
  
  });

}

gotoTelemetria(auto:Auto,idDispositivo:number): void {
	this.telemetriaService.setAuto(auto,idDispositivo);
	this.router.navigate(['telemetria']);
}

}