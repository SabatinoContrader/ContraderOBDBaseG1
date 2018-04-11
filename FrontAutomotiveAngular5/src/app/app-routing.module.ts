import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeOfficinaComponent } from './components/home-officina/home-officina.component';
import { HomepageComponent } from './components/homepage/homepage.component';


const routes: Routes = [
  { path: '', redirectTo:"/login", pathMatch:'full' },
  { path: 'login', component: LoginComponent },
  { path: 'homeofficina', component: HomeOfficinaComponent },
];


@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }
