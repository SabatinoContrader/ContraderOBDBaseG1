import { Appuntamento } from '../../models/Appuntamento';
import { Component, OnInit } from '@angular/core';
import { AppuntamentoService } from '../../services/appuntamento.service';
import { Utente } from '../../models/Utente';

@Component({
  selector: 'app-appuntamento',
  templateUrl: './appuntamento.component.html',
  styleUrls: ['./appuntamento.component.css']
})
export class AppuntamentoComponent implements OnInit {

  listaAppuntamenti: Appuntamento[];
  utente: Utente;

  constructor(private appuntamentoService: AppuntamentoService) { }

  ngOnInit() {
    this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
    this.appuntamentoService.getAppuntamenti(this.utente.id)
    .subscribe(
      response =>  { this.listaAppuntamenti = response.data } 
    );
  }

}
