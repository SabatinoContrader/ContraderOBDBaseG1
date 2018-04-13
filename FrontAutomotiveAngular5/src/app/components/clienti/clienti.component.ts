import { Utente } from '../../models/Utente';
import { Component, OnInit } from '@angular/core';
import { ClientiService } from '../../services/clienti.service';
import swal from 'sweetalert2';
declare var jquery:any;
declare var $ :any;


@Component({
  selector: 'app-clienti',
  templateUrl: './clienti.component.html',
  styleUrls: ['./clienti.component.css']
})
export class ClientiComponent implements OnInit {
listaClienti:any;
  utente: Utente;
  nome;
  cognome;
  email;
  password;
  telefono;
  
  constructor(private clientiService: ClientiService) { }

  ngOnInit() {
	  this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
	 this.getListaClienti();
	    
		
		
  }

  
  getListaClienti(): void{
	  this.clientiService.getClienti(this.utente.officina.id)
    .subscribe(
      response =>  { this.listaClienti = response.data } 
    );
  }
  
    
  public insertCliente(){
	  this.clientiService.insertCliente(this.nomecliente,this.cognomecliente,this.emailcliente,this.passwordcliente,this.utente.officina.id,this.telefonocliente).subscribe(
      (response) => {
		 this.getListaClienti();
      swal("Complimenti", "Cliente inserito correttamente", "success");

           $('#modaladdcliente').modal("hide");
      
      },
      err => {
        console.log("Error occured");
      });
  
  });

}
