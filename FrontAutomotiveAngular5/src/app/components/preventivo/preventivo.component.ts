import { Component, OnInit } from '@angular/core';
import { PreventivoService } from '../../services/preventivo.service';
import {Utente} from '../../models/Utente';
import { Router } from '@angular/router';
import * as $ from 'jquery';
declare var jquery:any;
declare var $ :any;
@Component({
  selector: 'app-preventivo',
  templateUrl: './preventivo.component.html',
  styleUrls: ['./preventivo.component.css']
})
export class PreventivoComponent implements OnInit {

  listaPreventivi:any;
utente: Utente;
idrispprev;
rispostaprev;
costorispprev:number;

  constructor(private preventivoService:PreventivoService, private router:Router) { }

  ngOnInit() {
	  this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
	  if(this.utente.ruolo==1){
	 this.loadPreventiviOfficina();
  }
 }
  
   rispondiPreventivo(): void {
	   
	   this.preventivoService.rispondiPreventivo(this.rispostaprev,this.costorispprev,this.idrispprev).subscribe(
    
      (response) => {
		  console.log(response);
       /* if (response) {
          
		  this.loginEntity = response;
		sessionStorage.setItem('loginEntity', JSON.stringify(this.loginEntity));
		this.auto = response.statoAuto;
		console.log(response.statoAuto);
		  alert('Auto inserita correttamente');
           $('#modaladdauto').modal("hide");
        }*/
		 this.loadPreventiviOfficina();
		alert('preventivo inviato correttamente');
		$('#modalrispondipreventivo').modal("hide");
      },
      err => {
        console.log("Error occured");
      });
       
    
  }
  
  openModalRispondiPreventivo(id:any):void{
	 this.idrispprev=id;

$('#modalrispondipreventivo').modal("show");
	  
  }
  
  loadPreventiviOfficina(): void {
	  this.preventivoService.listaPreventiviOfficina(this.utente.officina.id).subscribe(
	    (response) => {
		
		  console.log(response);
        if (response) {
          
		 this.listaPreventivi=response.data;
		console.log(this.listaPreventivi);
		
        }
      },
      err => {
        console.log("Error occured");
      });
  }
}


