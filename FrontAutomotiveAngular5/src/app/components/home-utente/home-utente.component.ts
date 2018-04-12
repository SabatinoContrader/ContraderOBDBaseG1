import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { Auto } from '../../models/Auto';
=======
>>>>>>> 9064245da25eefd953e98c6b7996f93fe7946375

@Component({
  selector: 'app-home-utente',
  templateUrl: './home-utente.component.html',
  styleUrls: ['./home-utente.component.css']
})
export class HomeUtenteComponent implements OnInit {

<<<<<<< HEAD
  listaAuto: Auto[];

  constructor() { }

  ngOnInit() {
    this.listaAuto = JSON.parse(sessionStorage.getItem("loginEntity")).listaAuto;
=======
  constructor() { }

  ngOnInit() {
>>>>>>> 9064245da25eefd953e98c6b7996f93fe7946375
  }

}
