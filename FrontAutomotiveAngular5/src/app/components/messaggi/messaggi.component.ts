import { Component, OnInit } from '@angular/core';
import { MessaggiService } from '../../services/messaggi.service';
import { Utente } from '../../models/Utente';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

import swal from 'sweetalert2';
declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-messaggi',
  templateUrl: './messaggi.component.html',
  styleUrls: ['./messaggi.component.css']
})
export class MessaggiComponent implements OnInit {
	utente: Utente;
	listaTicket:any;
	listaMessaggiModal:any;
	testomessaggio;
  constructor(private messaggiService: MessaggiService) { }

  ngOnInit() {
	   this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
	   this.loadTicket();
  }


  loadTicket(): void{
	  
	    this.messaggiService.getListaTicket(this.utente.officina.id)
      .subscribe(
        response => {console.log(response);  this.listaTicket = response.data }
      );
  }
  
openModalTicket(listaMessaggi:any): void{
	this.listaMessaggiModal=listaMessaggi;
	$('#modalticket').modal("show");
}

inviaMessaggio(): void {
	let dir;
	if(this.utente.ruolo==0)  dir = 0;
	else if(this.utente.ruolo==1) dir=1;
	console.log(this.listaMessaggiModal[0].ticket.id);
    this.messaggiService.inviaMessaggio(this.listaMessaggiModal[0].ticket.id, this.testomessaggio,dir)
      .subscribe((response) => {
        swal("Success", "Messaggio inviato con successo", "success");
		 this.loadTicket();
        $('#modalticket').modal("hide");
       
      });
  }
}

