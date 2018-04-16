import { NotificaAutoDTO } from '../../models/NotificaAutoDTO';
import { Component, OnInit } from '@angular/core';
import { PreventivoService } from '../../services/preventivo.service';
import { AutoService } from '../../services/auto.service';
import { Utente } from '../../models/Utente';
import { Router, ActivatedRoute } from '@angular/router';
import { Preventivo } from '../../models/Preventivo';
import { Auto } from '../../models/Auto';
declare var jquery: any;
declare var $: any;
import swal from 'sweetalert2';

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
  risp: string;
  stato: number;
  sub;
  filtropreventivi;
  constructor(private preventivoService: PreventivoService, private router: Router, private route: ActivatedRoute, private autoService: AutoService) { }

  ngOnInit() {
    this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
    this.sub = this.route.queryParams.subscribe(params => {

      // Prendere paremetro per visualizzare solo preventivi che voglio, se non ci sta imopsto a 0.
      // 0 - tutti, 1 - in attesa di risposta, 2 - risposti, 3 - accettati, 4 - rifiutati
      this.stato = +params['stato'] || 0;
      if (this.stato == 0) this.filtropreventivi = "Tutti";
      else if (this.stato == 1) this.filtropreventivi = "In Attesa Di Risposta";
      else if (this.stato == 2) this.filtropreventivi = "Risposti";
      else if (this.stato == 3) this.filtropreventivi = "Accettati";
      else if (this.stato == 4) this.filtropreventivi = "Rifiutati";

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
    });





  }

  chiediPreventivo(): void {
    this.preventivoService.chiediPreventivo(this.utente.email, this.dettagli, this.idAuto)
      .subscribe((response) => {
        swal("Successo", "Preventivo richiesto con successo", "success");
        $('#chiediPreventivoModal').modal("hide");
        this.loadPreventiviUtente();
      });
  }

  rispondiPreventivo(): void {

    this.preventivoService.rispondiPreventivo(this.rispostaprev, this.costorispprev, this.idrispprev).subscribe(

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
        this.loadPreventiviOfficina();
        swal("Complimenti", "Preventivo inviato correttamente", "success");
        $('#modalrispondipreventivo').modal("hide");
      },
      err => {
        console.log("Error occured");
      });


  }

  openModalRispondiPreventivo(id: any): void {
    this.idrispprev = id;

    $('#modalrispondipreventivo').modal("show");

  }

  public loadPreventiviOfficina(): void {
    this.preventivoService.listaPreventiviOfficina(this.utente.officina.id, this.stato).subscribe(
      (response) => {

        console.log(response);
        if (response) {
          this.listaPreventivi = [];
          this.listaPreventivi = response.data;
          console.log(this.listaPreventivi);

        }
      },
      err => {
        console.log("Error occured");
      });
  }

  loadPreventiviUtente(): void {
    this.preventivoService.listaPreventiviUtente(this.utente.id, this.stato).subscribe(
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

  accettaPreventivo(id: number, stato: number): void {
    this.preventivoService.accettaPreventivo(id, stato).subscribe(
      (response) => {
        console.log(response);
        console.log(this.listaPreventivi);
        if (stato == 2)
          this.risp = "accettato";
        if (stato == 3)
          this.risp = "rifiutato";
        this.loadPreventiviUtente();
        swal("Successo", "Il preventivo è stato " + this.risp, "success");
      },
      err => {
        console.log("Error occured");
      });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}


