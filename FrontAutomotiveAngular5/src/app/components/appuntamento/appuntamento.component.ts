import { Appuntamento } from '../../models/Appuntamento';
import { Component, OnInit } from '@angular/core';
import { AppuntamentoService } from '../../services/appuntamento.service';
import { Utente } from '../../models/Utente';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { Auto } from '../../models/Auto';
import { AutoService } from '../../services/auto.service';

import swal from 'sweetalert2';
declare var jquery: any;
declare var $: any;
@Component({
  selector: 'app-appuntamento',
  templateUrl: './appuntamento.component.html',
  styleUrls: ['./appuntamento.component.css']
})
export class AppuntamentoComponent implements OnInit {

  listaAppuntamenti: Appuntamento[];
  utente: Utente;
  dettagli: string = this.dettagli;
  data: NgbDateStruct = this.data;
  ora: string = this.ora;
  idrispapp;
  rispostaapp;
  statoappuntamento;

  constructor(private appuntamentoService: AppuntamentoService, private autoService: AutoService) { }
  ngOnInit() {
    this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
    if (this.utente.ruolo == 0) {
      this.loadAppuntamentiCliente();

    } else if (this.utente.ruolo == 1) {

      this.loadAppuntamentiOfficina();

    }


  }

  rispondiAppuntamento(): void {

    this.appuntamentoService.rispondiAppuntamento(this.rispostaapp, this.idrispapp, this.statoappuntamento).subscribe(

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
        this.loadAppuntamentiOfficina();
        swal("Complimenti", "appuntamento risposto correttamente", "success");

        $('#modalrispondipreventivo').modal("hide");
      },
      err => {
        console.log("Error occured");
      });


  }

  openModalRispondiAppuntamento(id: any): void {

    this.idrispapp = id;

    $('#modalrispondiappuntamento').modal("show");

  }

  loadAppuntamentiOfficina(): void {
    this.appuntamentoService.getAppuntamentiOfficina(this.utente.officina.id)
      .subscribe(
        response => { console.log("RISOPIs: " + response.data); this.listaAppuntamenti = response.data }
      );
  }
  loadAppuntamentiCliente(): void {
    this.appuntamentoService.getAppuntamenti(this.utente.id)
      .subscribe(
        response => { this.listaAppuntamenti = response.data }
      );
  }

  chiediAppuntamento(): void {
    this.appuntamentoService.chiediAppuntamento(this.utente.email, this.dettagli, this.ora, (this.data.day + "/" + this.data.month + "/" + this.data.year))
      .subscribe((response) => {
        swal("Success", "Appuntamento richiesto con successo", "success");
        $('#chiediAppuntamentoModal').modal("hide");
        this.loadAppuntamentiCliente();
      });
  }
}

}
