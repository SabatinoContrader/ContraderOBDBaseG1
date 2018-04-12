import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AngularFontAwesomeModule } from 'angular-font-awesome';



import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { OfficinaService } from './services/officina.service';
import { HomeOfficinaComponent } from './components/home-officina/home-officina.component';
<<<<<<< HEAD
=======
import { HomepageComponent } from './components/homepage/homepage.component';
>>>>>>> 9064245da25eefd953e98c6b7996f93fe7946375
import { HomeUtenteComponent } from './components/home-utente/home-utente.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeOfficinaComponent,
<<<<<<< HEAD
=======
    HomepageComponent,
>>>>>>> 9064245da25eefd953e98c6b7996f93fe7946375
    HomeUtenteComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFontAwesomeModule
  ],
  providers: [LoginService,OfficinaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
