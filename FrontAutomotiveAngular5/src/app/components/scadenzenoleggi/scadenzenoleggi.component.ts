import { Component, OnInit } from '@angular/core';
import { ScadenzenoleggiService } from '../../services/scadenzenoleggi.service';
import { Utente } from '../../models/Utente';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

import swal from 'sweetalert2';
declare var jquery: any;
declare var $: any;


@Component({
  selector: 'app-scadenzenoleggi',
  templateUrl: './scadenzenoleggi.component.html',
  styleUrls: ['./scadenzenoleggi.component.css']
})
export class ScadenzenoleggiComponent implements OnInit {

	 utente: Utente;
	listaScadenzeNoleggi:any;
	
  constructor(private scadenzenoleggiService:ScadenzenoleggiService ) { }

  ngOnInit() {
	   this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
	   this.getListaScadenzeNoleggi();
  }

   getListaScadenzeNoleggi(): void{
	  this.scadenzenoleggiService.getScadenzeNoleggiOfficina(this.utente.officina.id)
      .subscribe(
        response => {console.log(response);  this.listaScadenzeNoleggi = response.data }
      );
  }
}
