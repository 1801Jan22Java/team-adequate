import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { LoginComponent } from './login/login.component';
import { SearchComponent } from './search/search.component';
import { HomeComponent } from './home/home.component';
import { NavigationComponent } from './navigation/navigation.component';
import { AccountPageComponent } from './account-page/account-page.component';
import { PlaceComponent } from './place/place.component';
import { UserCardComponent } from './user-card/user-card.component';
import { UserPageComponent } from './user-page/user-page.component';

import { HttpClientModule } from '@angular/common/http';
import { ReviewCardComponent } from './review-card/review-card.component';
import { RegistrationComponent } from './registration/registration.component';
import { HttpService } from './Http.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SearchComponent,
    HomeComponent,
    NavigationComponent,
    AccountPageComponent,
    PlaceComponent,
    UserCardComponent,
    UserPageComponent,
    ReviewCardComponent,
    RegistrationComponent
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
