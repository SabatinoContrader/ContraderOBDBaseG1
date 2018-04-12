import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { OfficinaService } from './services/officina.service';
import { AutoService } from './services/auto.service';
import { HomeOfficinaComponent } from './components/home-officina/home-officina.component';
import { HomeUtenteComponent } from './components/home-utente/home-utente.component';
import { TopbarComponent } from './components/topbar/topbar.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AppuntamentoService } from './services/appuntamento.service';
import { PreventivoService } from './services/preventivo.service';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeOfficinaComponent,
    HomeUtenteComponent,
    TopbarComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFontAwesomeModule,
    NgbModule.forRoot()
  ],
  providers: [LoginService,OfficinaService,AutoService, AppuntamentoService, PreventivoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
