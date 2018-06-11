import { Component, OnInit } from '@angular/core';
import { ScadenzeService } from '../../services/scadenze.service';
import { Utente } from '../../models/Utente';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';


import swal from 'sweetalert2';
declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-scadenze',
  templateUrl: './scadenze.component.html',
  styleUrls: ['./scadenze.component.css']
})
export class ScadenzeComponent implements OnInit {
 utente: Utente;
	listaScadenze:any;
  constructor(private scadenzeService:ScadenzeService) { }

  ngOnInit() {
	   this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
	   this.loadScadenze();
  }

  
  loadScadenze(): void{
	  this.scadenzeService.getAutoInScadenza(this.utente.id)
      .subscribe(
        response => {console.log(response);  this.listaScadenze = response.data }
      );
  }
}
