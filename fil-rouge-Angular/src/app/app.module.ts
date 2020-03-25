import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

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
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: WelcomeComponent},
      { path: 'sign-up', component: SignUpComponent},    // chemin du path correspond à ce qui est saisi dans "route.param" 
      { path: 'login', component: LoginComponent},
      { path: 'publications-list', component: PublicationsListComponent},
      // { path: 'createPublication', component:createPublicationComponent} 
      ]
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
