import { Component, OnInit } from '@angular/core';
import { AppuntamentoService } from '../../services/appuntamento.service';

@Component({
  selector: 'app-appuntamento',
  templateUrl: './appuntamento.component.html',
  styleUrls: ['./appuntamento.component.css']
})
export class AppuntamentoComponent implements OnInit {

  constructor(private appuntamentoService: AppuntamentoService) { }

  ngOnInit() {
  }

}
