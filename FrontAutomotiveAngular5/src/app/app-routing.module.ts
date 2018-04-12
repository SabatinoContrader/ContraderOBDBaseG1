import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeOfficinaComponent } from './components/home-officina/home-officina.component';
import { HomeUtenteComponent } from './components/home-utente/home-utente.component';


const routes: Routes = [
  { path: '', redirectTo:"/login", pathMatch:'full' },
  { path: 'login', component: LoginComponent },
  { path: 'homeofficina', component: HomeOfficinaComponent },
<<<<<<< HEAD
  { path: 'homeutente', component: HomeUtenteComponent}

=======
>>>>>>> 9064245da25eefd953e98c6b7996f93fe7946375
];


@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }
