import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { LoginServiceService} from '../login-service.service';
import { Publication} from '../publication';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm;
  loginService;
  publications: Publication[];
  isLoggedIn: Boolean = false;;
  // publicationService;

  constructor(private forbuilder : FormBuilder,
    loginService: LoginServiceService
    // publicationService: PublicationsServiceService
    ) {
    this.loginForm = this.forbuilder.group (
    {
      nickName : ''
    }
  )  }

  ngOnInit() {
  }

  onSubmit(login) {

    // this.loginService.checkUser(login).subscribe(
    //   user => {
        console.log("exists in Backend")
       // console.log(user);
         // Save login in Localstorage

        let key = 'nickName';
       // localStorage.setItem(key,JSON.stringify(user.nickName));
        localStorage.setItem(key,JSON.stringify(login.nickName));
        // get on Publication List restreints (Edition possible on user's created Publications)
        this.isLoggedIn = true;
        
      //   },
      // err => alert('Wrong login')
      // );
    
       // clear user creation form once creation completed
       this.loginForm.reset();
  }
}
