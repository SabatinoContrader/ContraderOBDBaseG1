import { Appuntamento } from '../../models/Appuntamento';
import { Component, OnInit } from '@angular/core';
import { AppuntamentoService } from '../../services/appuntamento.service';
import { Utente } from '../../models/Utente';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { Auto } from '../../models/Auto';
import { AutoService } from '../../services/auto.service';

@Component({
  selector: 'app-appuntamento',
  templateUrl: './appuntamento.component.html',
  styleUrls: ['./appuntamento.component.css']
})
export class AppuntamentoComponent implements OnInit {

  listaAppuntamenti: Appuntamento[];
  utente: Utente;
  listaAutoUtente: Auto[];
  idAuto: number = this.idAuto;
  dettagli: string = this.dettagli;
  data: NgbDateStruct = this.data;
  ora: string = this.ora;

  constructor(private appuntamentoService: AppuntamentoService, private autoService: AutoService) { }

  ngOnInit() {
    this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
    this.appuntamentoService.getAppuntamenti(this.utente.id)
    .subscribe(
      response =>  { this.listaAppuntamenti = response.data } 
    );
  }

}
