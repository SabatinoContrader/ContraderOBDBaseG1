import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeOfficinaComponent } from './components/home-officina/home-officina.component';
import { HomeUtenteComponent } from './components/home-utente/home-utente.component';
import { AppuntamentoComponent } from './components/appuntamento/appuntamento.component';
import { PreventivoComponent } from './components/preventivo/preventivo.component';
import { ClientiComponent } from './components/clienti/clienti.component';


const routes: Routes = [
  { path: '', redirectTo:"/login", pathMatch:'full' },
  { path: 'login', component: LoginComponent },
  { path: 'homeofficina', component: HomeOfficinaComponent },
  { path: 'homeutente', component: HomeUtenteComponent},
  { path: 'appuntamenti', component: AppuntamentoComponent},
  { path: 'preventivi', component: PreventivoComponent},
  { path: 'clienti', component: ClientiComponent}
];


@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }
