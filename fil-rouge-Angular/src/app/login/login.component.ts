import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { LoginServiceService} from '../login-service.service';
import { PublicationsListComponent } from '../publications-list/publications-list.component';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm;
  loginService;
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
      user => {console.log("User exists in Backend")
      
    // get on Publication List restreints
    // this.PublicationService.getPublicationsForUser().subscribe(
    //   publications => { }
    // );
  }
    );
    
       // clean user creation form once creation completed
       this.loginForm.reset();
  }
}
