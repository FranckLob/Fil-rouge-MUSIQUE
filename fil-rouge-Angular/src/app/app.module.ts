import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';

import { PublicationsListComponent } from './publications-list/publications-list.component';
import { TopBarComponent } from './top-bar/top-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    SignUpComponent,
    LoginComponent,
    PublicationsListComponent,
    TopBarComponent
    
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: '', component: WelcomeComponent},
      { path: 'sign-up', component: SignUpComponent},    // chemin du path correspond à ce qui est saisi dans "route.param" 
      { path: 'login', component: LoginComponent},
      { path: 'publications-list', component: PublicationsListComponent}, 
      ]

    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
