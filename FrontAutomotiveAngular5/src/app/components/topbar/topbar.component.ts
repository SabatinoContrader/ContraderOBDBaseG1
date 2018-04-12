import { Component, OnInit,Input  } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { LoginEntity } from '../../models/LoginEntity';
import { Router} from '@angular/router';

import { AppRoutingModule } from '../../app-routing.module';
@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent implements OnInit {
	utente:LoginEntity;
	scadenze:number;
  constructor(private loginService:LoginService,private router:Router) { }
  
 ngOnInit() {
	 
    if (this.loginService.isLogged()) {
		 
		this.utente=JSON.parse(sessionStorage.getItem("loginEntity"));
	this.scadenze=this.utente.numScadenze+this.utente.numKmNoleggio;
    }
  }

}
