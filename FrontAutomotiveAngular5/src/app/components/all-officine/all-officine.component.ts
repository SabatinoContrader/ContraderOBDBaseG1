import { Component, OnInit } from '@angular/core';
import { OfficinaService } from '../../services/officina.service';
import { Officina } from '../../models/Officina';

@Component({
  selector: 'app-all-officine',
  templateUrl: './all-officine.component.html',
  styleUrls: ['./all-officine.component.css']
})
export class AllOfficineComponent implements OnInit {
  listaOfficine: Officina[];

  constructor(private officinaService: OfficinaService) { }

  ngOnInit() {
    this.officinaService.getAllOfficine().subscribe( response => {this.listaOfficine = response.data})
  }
}
