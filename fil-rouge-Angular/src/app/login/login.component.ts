import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { LoginServiceService} from '../login-service.service';
import { Publication} from '../publication';
import { Router } from '@angular/router';
import { IsLoggedInService } from '../is-logged-in.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm;
  publications: Publication[];

  constructor(private forbuilder : FormBuilder,
    private loginService: LoginServiceService,
    private routerNav: Router,
    private isLoggedService: IsLoggedInService
    ) {
    this.loginForm = this.forbuilder.group (
    {
      nickName : ''
    }
  )  }

  ngOnInit() {
  }

  onSubmit(login) {
    
    this.loginService.checkUser(login.nickName).subscribe(
      user => {
        //   Save login in Localstorage
        let key = 'nickName';
        localStorage.setItem(key,JSON.stringify(user.nickName));

        // Activate isLoginFlags for top-bar-component show
        this.isLoggedService.ngOnInit();
        
        // Go to PublicationList with Login provided on top-bar (Edition possible on user's created Publications only)
        this.routerNav.navigate(['publications-list']);      
        },
      // Show error wrong login
      err => alert('Wrong login, please try again')
      );
    
       // clear user creation form once creation completed
       this.loginForm.reset();
  }
}
