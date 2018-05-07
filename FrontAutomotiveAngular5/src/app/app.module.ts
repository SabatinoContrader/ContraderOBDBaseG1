import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SweetAlert2Module } from '@toverux/ngx-sweetalert2';
import { AgmCoreModule } from '@agm/core';
import { Observable } from 'rxjs/Observable';

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
import { ScadenzeService } from './services/scadenze.service';
import { TelemetriaService } from './services/telemetria.service';
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
import { TicketComponent } from './components/ticket/ticket.component'
import { TelemetriaComponent } from './components/telemetria/telemetria.component';
import { HomeAdminComponent } from './components/home-admin/home-admin.component';
import { AllAutoComponent } from './components/all-auto/all-auto.component';
import { APP_BASE_HREF } from '@angular/common';
import { AllOfficineComponent } from './components/all-officine/all-officine.component';
import { AmChartsModule } from "@amcharts/amcharts3-angular";
import {  IMqttMessage,  MqttModule,  MqttService,  IMqttServiceOptions} from 'ngx-mqtt';
import { SingolaTelemetriaComponent } from './components/singola-telemetria/singola-telemetria.component';

export const MQTT_SERVICE_OPTIONS: IMqttServiceOptions = {
  hostname: 'broker.mqttdashboard.com',
  port: 8000,
  path: '/mqtt'
};
 
export function mqttServiceFactory() {
  return new MqttService(MQTT_SERVICE_OPTIONS);
}

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
    TicketComponent,
    TelemetriaComponent,
    HomeAdminComponent,
    AllAutoComponent,
    AllOfficineComponent,
    SingolaTelemetriaComponent
    
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
    }),
    DataTablesModule,
   AmChartsModule,
   MqttModule.forRoot({
    provide: MqttService,
    useFactory: mqttServiceFactory
  })
  ],

  providers: [LoginService, OfficinaService, AutoService, AppuntamentoService, ClientiService, PreventivoService, GuastiService, DispositiviService,NoleggiService,MessaggiService,ScadenzenoleggiService,ScadenzeService,TelemetriaService, { provide: APP_BASE_HREF, useValue : '/' }],


  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
