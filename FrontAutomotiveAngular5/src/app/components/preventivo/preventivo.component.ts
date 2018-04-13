import { NotificaAutoDTO } from '../../models/NotificaAutoDTO';
import { Component, OnInit } from '@angular/core';
import { PreventivoService } from '../../services/preventivo.service';
import { AutoService } from '../../services/auto.service';
import { Utente } from '../../models/Utente';
import { Router } from '@angular/router';
<<<<<<< HEAD
import * as $ from 'jquery';
import { Preventivo } from '../../models/Preventivo';
import { Auto } from '../../models/Auto';
declare var jquery: any;
declare var $: any;
=======
import swal from 'sweetalert2';
		
declare var jquery:any;
declare var $ :any;
>>>>>>> 70de8059ded49e6e573b2598ce6396d1179c6813
@Component({
  selector: 'app-preventivo',
  templateUrl: './preventivo.component.html',
  styleUrls: ['./preventivo.component.css']
})
export class PreventivoComponent implements OnInit {

  listaPreventivi: Preventivo[];
  listaAutoUtente: Auto[];
  utente: Utente;
  idrispprev;
  rispostaprev;
  costorispprev: number;
  idAuto: number = this.idAuto;
  dettagli: string = this.dettagli;

  constructor(private preventivoService: PreventivoService, private router: Router, private autoService: AutoService) { }

  ngOnInit() {
    this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;

    if (this.utente.ruolo == 1) {
      this.loadPreventiviOfficina();
    }
    if (this.utente.ruolo == 0) {
      this.loadPreventiviUtente();
      this.autoService.listaAutoUtente(this.utente.id).subscribe(
        (response) => {
          console.log(response);
          if (response) {
            this.listaAutoUtente = response.data;
          }
        },
        err => {
          console.log("Error occured");
        });
      console.log(this.listaAutoUtente);
    }
  }

  chiediPreventivo(): void {
    this.preventivoService.chiediPreventivo(this.utente.email, this.dettagli, this.idAuto).subscribe();
  }

  rispondiPreventivo(): void {

    this.preventivoService.rispondiPreventivo(this.rispostaprev, this.costorispprev, this.idrispprev).subscribe(

      (response) => {
<<<<<<< HEAD
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
=======
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
		swal("Complimenti", "Preventivo inviato correttamente", "success");
		$('#modalrispondipreventivo').modal("hide");
>>>>>>> 70de8059ded49e6e573b2598ce6396d1179c6813
      },
      err => {
        console.log("Error occured");
      });


  }

  openModalRispondiPreventivo(id: any): void {
    this.idrispprev = id;

    $('#modalrispondipreventivo').modal("show");

  }

  loadPreventiviOfficina(): void {
    this.preventivoService.listaPreventiviOfficina(this.utente.officina.id).subscribe(
      (response) => {

        console.log(response);
        if (response) {

          this.listaPreventivi = response.data;
          console.log(this.listaPreventivi);

        }
      },
      err => {
        console.log("Error occured");
      });
  }

  loadPreventiviUtente(): void {
    this.preventivoService.listaPreventiviUtente(this.utente.id).subscribe(
      (response) => {
        console.log(response);
        if (response) {
          this.listaPreventivi = response.data;
          console.log(this.listaPreventivi);
        }
      },
      err => {
        console.log("Error occured");
      });
  }

  accettaPreventivo(id: number, stato: number, ): void {
    this.preventivoService.accettaPreventivo(id, stato).subscribe(
      (response) => {
        console.log(response);
        if (response) {
          console.log(this.listaPreventivi);
        }
      },
      err => {
        console.log("Error occured");
      });
  }
}


