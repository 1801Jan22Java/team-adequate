// Modules
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AccountPageComponent } from './account-page/account-page.component';
import { PlaceComponent } from './place/place.component';

// Components
const appRoutes: Routes = [

  //Routes for the login page
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},

  //Home routes
  { path: 'search', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent},

  //Account routes
  { path: 'account', component: AccountPageComponent},

  //TODO: Place routes (temp should only be able to navigate from search)
  { path: 'place', component: PlaceComponent},

  //Might want to change this to an error/404 page?
  { path: '**', redirectTo: '/login' },

];


@NgModule({
  imports: [
    // TODO: disable tracing!!!!!!!
    RouterModule.forRoot( appRoutes, { enableTracing: true } /* <-- debugging purposes only */)

],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
