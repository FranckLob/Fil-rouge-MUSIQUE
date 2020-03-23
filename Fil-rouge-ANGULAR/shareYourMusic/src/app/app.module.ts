import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { PublicationListComponent } from './publication-list/publication-list.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    WelcomeComponent,
    SignUpComponent,
    LoginComponent,
    PublicationListComponent,
    
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: '', component: WelcomeComponent},
      { path: 'sign-up', component: SignUpComponent},    // chemin du path correspond à ce qui est saisi dans "route.param" 
      { path: 'login', component: LoginComponent},
      { path: 'publication-list', component: PublicationListComponent}, 
      ]

    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
