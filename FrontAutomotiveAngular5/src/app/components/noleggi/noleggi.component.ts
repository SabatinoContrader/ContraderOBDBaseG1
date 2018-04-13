import { Utente } from '../../models/Utente';
import { Component, OnInit } from '@angular/core';
import { NoleggiService } from '../../services/noleggi.service';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import swal from 'sweetalert2';

declare var jquery:any;
declare var $ :any;
const now = new Date();

@Component({
  selector: 'app-noleggi',
  templateUrl: './noleggi.component.html',
  styleUrls: ['./noleggi.component.css']
})
export class NoleggiComponent implements OnInit {
listaNoleggi: any;
	utente: Utente;
	idAuto;
	idUtente;
	CapLuogoDiRiconsegna;
	CapLuogoDiRitiro;
	DataInizioNoleggio;
	DataFineNoleggio;
	
	
  constructor(private noleggiService: NoleggiService) { }

  ngOnInit() {
	   this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
	 this.getListaNoleggi();
  }

   getListaNoleggi(): void{
	  this.noleggiService.getNoleggi(this.utente.officina.id)
    .subscribe(
      response =>  { this.listaNoleggi = response.data } 
    );
  }
  
}
