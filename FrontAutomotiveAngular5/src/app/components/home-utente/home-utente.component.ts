import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Auto } from '../../models/Auto';
import { StatoAutoDTO } from '../../models/StatoAutoDTO';
import { NotificaAutoDTO } from '../../models/NotificaAutoDTO';
import { AutoService } from '../../services/auto.service';
import { AppuntamentoService } from '../../services/appuntamento.service';
import { PreventivoService } from '../../services/preventivo.service';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
declare var jquery: any;
declare var $: any;
import swal from 'sweetalert2';

const now = new Date();

@Component({
  selector: 'app-home-utente',
  templateUrl: './home-utente.component.html',
  styleUrls: ['./home-utente.component.css']
})
export class HomeUtenteComponent implements OnInit {

  listaAuto: StatoAutoDTO[];
  autoNotificata: Auto;
  notificheAuto: NotificaAutoDTO[];
  notifica: NotificaAutoDTO;
  data: NgbDateStruct = this.data;
  ora: string = this.ora;
  dettagli: string = this.dettagli;

  notifiche(auto: Auto): void {
    this.autoNotificata = auto;
    this.autoService.getNotifiche(auto.id)
      .subscribe(
        response => { this.notificheAuto = response.data }
      );
  }

  formAppuntamento(notifica: NotificaAutoDTO): void {
    this.notifica = notifica;
    this.dettagli = notifica.value;
  }

  formPreventivo(notifica: NotificaAutoDTO): void {
    this.notifica = notifica;
    this.dettagli = notifica.value;
  }

  chiediAppuntamento(): void {
    console.log("funzione chiediAppuntamento");
    this.appuntamentoService.chiediAppuntamento(JSON.parse(sessionStorage.getItem("loginEntity")).utente.email, this.dettagli, this.ora, (this.data.day + "/" + this.data.month + "/" + this.data.year))
      .subscribe((response) => {
        swal("Success", "Appuntamento richiesto con successo", "success");
        $('#chiediAppuntamentoModal').modal("hide");
      });
  }

  chiediPreventivo(): void {
    this.preventivoService.chiediPreventivo(JSON.parse(sessionStorage.getItem("loginEntity")).utente.email, this.dettagli, this.autoNotificata.id)
      .subscribe((response) => {
        swal("Success", "Preventivo richiesto con successo", "success");
        $('#chiediPreventivoModal').modal("hide");
      });
  }

  constructor(private autoService: AutoService, private router: Router, private appuntamentoService: AppuntamentoService, private preventivoService: PreventivoService) { }

  ngOnInit() {
    this.listaAuto = JSON.parse(sessionStorage.getItem("loginEntity")).statoAuto;
  }

}
