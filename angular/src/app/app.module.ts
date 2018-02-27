import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  //Login page?
  { path: 'login', component: AppComponent},
  { path: 'home', redirectTo: '/login',   data: { title: 'Heroes List' } },
  
  //Might want to change this to an error page?
  { path: '**', redirectTo: '/login' }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [

    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    
    BrowserModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
