import { Component, OnInit } from '@angular/core';
import { Auto } from '../../models/Auto';

@Component({
  selector: 'app-home-utente',
  templateUrl: './home-utente.component.html',
  styleUrls: ['./home-utente.component.css']
})
export class HomeUtenteComponent implements OnInit {

  listaAuto: Auto[];

  constructor() { }

  ngOnInit() {
    this.listaAuto = JSON.parse(sessionStorage.getItem("loginEntity")).listaAuto;
  }

}
