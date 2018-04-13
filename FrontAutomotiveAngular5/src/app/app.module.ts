import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { SweetAlert2Module } from '@toverux/ngx-sweetalert2';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { OfficinaService } from './services/officina.service';
import { AutoService } from './services/auto.service';
import { GuastiService } from './services/guasti.service';
import { HomeOfficinaComponent } from './components/home-officina/home-officina.component';
import { HomeUtenteComponent } from './components/home-utente/home-utente.component';
import { TopbarComponent } from './components/topbar/topbar.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AppuntamentoService } from './services/appuntamento.service';
import { PreventivoService } from './services/preventivo.service';
import { GuastiComponent } from './components/guasti/guasti.component';
import { PreventivoComponent } from './components/preventivo/preventivo.component';
import { AppuntamentoComponent } from './components/appuntamento/appuntamento.component';
import { DataTablesModule } from 'angular-datatables';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeOfficinaComponent,
    HomeUtenteComponent,
    TopbarComponent,
    NavbarComponent,
    GuastiComponent,
    PreventivoComponent,
    AppuntamentoComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFontAwesomeModule,
    NgbModule.forRoot(),
    SweetAlert2Module.forRoot(),
	 DataTablesModule
  ],
  providers: [LoginService,OfficinaService,AutoService, AppuntamentoService, PreventivoService, GuastiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
