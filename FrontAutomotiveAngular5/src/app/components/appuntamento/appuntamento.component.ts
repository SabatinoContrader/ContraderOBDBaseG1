import { Appuntamento } from '../../models/Appuntamento';
import { Component, OnInit, ApplicationRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
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
  stato: number;
  sub;
  filtroappuntamenti;
  constructor(private ref: ApplicationRef, private appuntamentoService: AppuntamentoService, private autoService: AutoService, private router: Router, private route: ActivatedRoute) { }
  ngOnInit() {
    this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;

    this.sub = this.route.queryParams.subscribe(params => {

      // Prendere paremetro per visualizzare solo preventivi che voglio, se non ci sta imopsto a 0.
      // 0 - tutti, 1 - in attesa di risposta, 2 - risposti, 3 - accettati, 4 - rifiutati
      this.stato = +params['stato'] || 0;
      if (this.stato == 0) this.filtroappuntamenti = "Tutti";
      else if (this.stato == 1) this.filtroappuntamenti = "In Attesa Di Risposta";
      else if (this.stato == 2) this.filtroappuntamenti = "Confermati";
      else if (this.stato == 3) this.filtroappuntamenti = "Rifiutati";

      if (this.utente.ruolo == 0) {
        this.loadAppuntamentiCliente();

      } else if (this.utente.ruolo == 1) {

        this.loadAppuntamentiOfficina();

      }

    });

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
    this.appuntamentoService.getAppuntamentiOfficina(this.utente.officina.id, this.stato)
      .subscribe(
        response => {
        this.listaAppuntamenti = response.data; this.ref.tick();
        }
      );
  }
  loadAppuntamentiCliente(): void {
    this.appuntamentoService.getAppuntamenti(this.utente.id, this.stato)
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

  ngOnDestroy() {
    if (this.sub != null) {
      this.sub.unsubscribe();
    }
  }

}


