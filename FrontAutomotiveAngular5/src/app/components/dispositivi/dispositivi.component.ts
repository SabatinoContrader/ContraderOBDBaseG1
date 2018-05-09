import { Utente } from '../../models/Utente';
import { Component, OnInit } from '@angular/core';
import { DispositiviService } from '../../services/dispositivi.service';
import { Observable } from 'rxjs/Observable';
import { IntervalObservable } from 'rxjs/observable/intervalObservable';
import 'rxjs/add/operator/takeWhile';

import swal from 'sweetalert2';
declare var jquery:any;
declare var $ :any;

@Component({
  selector: 'app-dispositivi',
  templateUrl: './dispositivi.component.html',
  styleUrls: ['./dispositivi.component.css']
})
export class DispositiviComponent implements OnInit {
	listaDispositivi: any;
	listaDispositiviPosizione:any;
	utente: Utente;
	codice;
	iddisp;
	listaAutoSenzaDispositivo:any;
	autodaassociare;
	lat: number = 41.54061;
  lng: number = 14.381826;
  infoWindowOpened;
   private alive: boolean;
   
  constructor(private dispositiviService: DispositiviService) {   this.alive = true; }

  ngOnInit() {
	    this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
	 this.getListaDispositivi();
	 this.getDispositiviPosizione();
	 
/*	 
    IntervalObservable.create(10000)
      .takeWhile(() => this.alive)
      .subscribe(() => {
         this.getDispositiviPosizione();
      });
*/
  }

  aggiornaPosizioni(): void{
	  this.getDispositiviPosizione();
  }
  
   getListaDispositivi(): void{
	  this.dispositiviService.getDispositivi(this.utente.officina.id)
    .subscribe(
      response =>  { this.listaDispositivi = response.data ; } 
    );
  }
  
  getDispositiviPosizione(): void{
	  
 this.dispositiviService.getDispositiviPosizione(this.utente.officina.id)
    .subscribe(
      response =>  { this.listaDispositiviPosizione = response ; } 
    );
  }
  
  
clickedMarker(label: string, infoWindow, marker, index: number) {
    if (this.infoWindowOpened === infoWindow) {
        console.log("window already opened");
        return;
    }

    if (this.infoWindowOpened !== null && this.infoWindowOpened !== undefined) {
        this.infoWindowOpened.close();
    }
    this.infoWindowOpened = infoWindow;
}
  
      
  public insertDispositivo(){
	  this.dispositiviService.insertDispositivo(this.utente.officina.id,this.codice).subscribe(
      (response) => {
		 this.getListaDispositivi();
      swal("Complimenti", "Dispositivo inserito correttamente", "success");
this.codice=null;
           $('#modaladddispositivo').modal("hide");
      
      },
      err => {
        console.log("Error occured");
      });
  
  };
  
    openModalAssociaDispositivo(id: any): void {
    this.iddisp = id;

	this.dispositiviService.getAutoSenzaDispositivi(this.utente.officina.id).subscribe(
      (response) => {

     this.listaAutoSenzaDispositivo=response.data;

	$('#modalassociaauto').modal("show");      
      },
      err => {
        console.log("Error occured");
      });
	
  }
  
    public associaDispositivo(){
	  this.dispositiviService.associaDispositivo(this.iddisp,this.autodaassociare).subscribe(
      (response) => {
		 this.getListaDispositivi();
      swal("Complimenti", "Dispositivo associato correttamente", "success");

           $('#modalassociaauto').modal("hide");
      
      },
      err => {
        console.log("Error occured");
      });
  
  };
  
}