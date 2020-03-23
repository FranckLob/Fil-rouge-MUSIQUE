import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { UserCreateComponent } from './user-create/user-create.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    WelcomeComponent,
    UserCreateComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: '', component: WelcomeComponent},
      { path: 'Welcome/UserCreate', component: UserCreateComponent},    // chemin du path correspond à ce qui est saisi dans "route.param"  
      ]

    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
