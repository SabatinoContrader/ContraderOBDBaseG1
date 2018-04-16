import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent implements OnInit {
  utente: any;
  allAuto: number;
  allOfficine: number;
  allAziende: number;
  allUtenti: number;

  constructor() { }

  ngOnInit() {
    this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
    this.allAuto = JSON.parse(sessionStorage.getItem("loginEntity")).numGuasti;
    this.allOfficine = JSON.parse(sessionStorage.getItem("loginEntity")).numScadenze;
    this.allAziende = JSON.parse(sessionStorage.getItem("loginEntity")).numKmNoleggio;
    this.allUtenti = JSON.parse(sessionStorage.getItem("loginEntity")).numAppuntamenti;

  }

}
