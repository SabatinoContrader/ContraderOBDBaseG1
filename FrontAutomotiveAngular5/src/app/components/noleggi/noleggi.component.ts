import { Utente } from '../../models/Utente';
import { Component, OnInit } from '@angular/core';
import { NoleggiService } from '../../services/noleggi.service';
import { ClientiService } from '../../services/clienti.service';
import { AutoService } from '../../services/auto.service';
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
listaClienti: any;
listaAutoNoleggiabili: any;
	utente: Utente;
	idAuto;
	clientenoleggio;
	CapLuogoDiRiconsegna;
	CapLuogoDiRitiro;
	DataInizioNoleggio;
	DataFineNoleggio;
	autonoleggio;
	
  constructor(private noleggiService: NoleggiService,private clientiService: ClientiService,private autoService: AutoService) { }

  ngOnInit() {
	   this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
	 this.getListaNoleggi();
	 
	 this.clientiService.getClienti(this.utente.officina.id)
    .subscribe(
      response =>  { this.listaClienti = response.data } 
    );
	 
	  this.autoService.getAutoNoleggiabili(this.utente.officina.id,1)
    .subscribe(
      response =>  { this.listaAutoNoleggiabili = response.data } 
    );
  }

   getListaNoleggi(): void {
	  this.noleggiService.getNoleggi(this.utente.officina.id)
    .subscribe(
      response =>  { this.listaNoleggi = response.data } 
    );
  }
  
  insertNoleggio(): void {
    this.noleggiService.insertNoleggio(this.utente.officina.id, this.autonoleggio, this.CapLuogoDiRiconsegna, this.CapLuogoDiRitiro, this.DataInizioNoleggio.day + "/" + this.DataInizioNoleggio.month + "/" + this.DataInizioNoleggio.year, this.DataFineNoleggio.day + "/" + this.DataFineNoleggio.month + "/" + this.DataFineNoleggio.year, this.clientenoleggio).subscribe((response) => {
        swal("Success", "Auto noleggiata correttamente", "success");
        $('#modalassegnanoleggio').modal("hide");
        this.getListaNoleggi();
      });
  }
}
