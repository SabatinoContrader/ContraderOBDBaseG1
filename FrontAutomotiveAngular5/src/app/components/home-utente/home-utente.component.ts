import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Auto } from '../../models/Auto';
import { StatoAutoDTO } from '../../models/StatoAutoDTO';
import { NotificaAutoDTO } from '../../models/NotificaAutoDTO';
import { AutoService } from '../../services/auto.service';
import { AppuntamentoService } from '../../services/appuntamento.service';
import { PreventivoService } from '../../services/preventivo.service';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

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
  data: string = this.data;
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
    this.appuntamentoService.chiediAppuntamento(JSON.parse(sessionStorage.getItem("loginEntity")).utente.email, this.dettagli, this.ora, this.data);
  }

  chiediPreventivo(): void {
    this.preventivoService.chiediPreventivo(JSON.parse(sessionStorage.getItem("loginEntity")).utente.email, this.dettagli, this.autoNotificata.id);
  }

  constructor(private autoService: AutoService, private router: Router, private appuntamentoService: AppuntamentoService, private preventivoService: PreventivoService) { }

  ngOnInit() {
    this.listaAuto = JSON.parse(sessionStorage.getItem("loginEntity")).statoAuto;
  }

}
