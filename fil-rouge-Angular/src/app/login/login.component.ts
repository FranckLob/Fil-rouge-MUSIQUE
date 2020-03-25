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
  // publicationService;

  constructor(private forbuilder : FormBuilder,
    loginService: LoginServiceService,
    // publicationService: PublicationsServiceService
    ) {
    this.loginForm = this.forbuilder.group (
    {
      nickName : ''
    }
  )  }

  ngOnInit() {
  }

  onSubmit(login:String) {


    this.loginService.checkUser(login).subscribe(
      user => {
        console.log(user + "exists in Backend")
         // Save login in Localstorage

        let key = 'login';
        localStorage.setItem(key,JSON.stringify(user));
        // get on Publication List restreints (Edition possible on user's created Publications)

        // this.PublicationService.getPublicationsForUsers().subscribe(
        //   publicationPage => {publications = publicationPage.content}
        // );
        },
      err => alert('Wrong login')
      );
    
       // clear user creation form once creation completed
       this.loginForm.reset();
  }
}
