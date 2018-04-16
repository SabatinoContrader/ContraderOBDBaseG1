import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SweetAlert2Module } from '@toverux/ngx-sweetalert2';
import { AgmCoreModule } from '@agm/core';

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
import { DispositiviService } from './services/dispositivi.service';
import { PreventivoService } from './services/preventivo.service';
import { ClientiService } from './services/clienti.service';
import { NoleggiService } from './services/noleggi.service';
import { MessaggiService } from './services/messaggi.service';
import { ScadenzenoleggiService } from './services/scadenzenoleggi.service';
import { GuastiComponent } from './components/guasti/guasti.component';
import { PreventivoComponent } from './components/preventivo/preventivo.component';
import { AppuntamentoComponent } from './components/appuntamento/appuntamento.component';
import { DataTablesModule } from 'angular-datatables';
import { ClientiComponent } from './components/clienti/clienti.component';
import { DispositiviComponent } from './components/dispositivi/dispositivi.component';
import { NoleggiComponent } from './components/noleggi/noleggi.component';
import { ScadenzeComponent } from './components/scadenze/scadenze.component';
import { ScadenzenoleggiComponent } from './components/scadenzenoleggi/scadenzenoleggi.component';
import { MessaggiComponent } from './components/messaggi/messaggi.component';
import { TelemetriaComponent } from './components/telemetria/telemetria.component';


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
    AppuntamentoComponent,
    ClientiComponent,
    DispositiviComponent,
    NoleggiComponent,
    ScadenzeComponent,
    ScadenzenoleggiComponent,
    MessaggiComponent,
    TicketComponent
    TelemetriaComponent
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
    DataTablesModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDpcHsNE3KygLr1IibNCgDgWJREv5v1hzc'
    })
  ],
  providers: [LoginService, OfficinaService, AutoService, AppuntamentoService, ClientiService, PreventivoService, GuastiService, DispositiviService],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
