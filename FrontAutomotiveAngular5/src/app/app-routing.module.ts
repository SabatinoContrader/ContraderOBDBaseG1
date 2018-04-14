import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeOfficinaComponent } from './components/home-officina/home-officina.component';
import { HomeUtenteComponent } from './components/home-utente/home-utente.component';
import { AppuntamentoComponent } from './components/appuntamento/appuntamento.component';
import { PreventivoComponent } from './components/preventivo/preventivo.component';
import { ClientiComponent } from './components/clienti/clienti.component';
import { DispositiviComponent } from './components/dispositivi/dispositivi.component';
import { NoleggiComponent } from './components/noleggi/noleggi.component';
import { GuastiComponent } from './components/guasti/guasti.component';
import { ScadenzeComponent } from './components/scadenze/scadenze.component';

const routes: Routes = [
  { path: '', redirectTo:"/login", pathMatch:'full' },
  { path: 'login', component: LoginComponent },
  { path: 'homeofficina', component: HomeOfficinaComponent },
  { path: 'homeutente', component: HomeUtenteComponent},
  { path: 'appuntamenti', component: AppuntamentoComponent},
  { path: 'preventivi', component: PreventivoComponent},
  { path: 'clienti', component: ClientiComponent},
  { path: 'dispositivi', component: DispositiviComponent},
  { path: 'noleggi', component: NoleggiComponent},
  { path: 'guasti', component: GuastiComponent},
  { path: 'scadenze', component: ScadenzeComponent}
  
];


@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }
