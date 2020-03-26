import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { User } from '../user';
import {SignUpServiceService} from '../sign-up-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signUpForm;
  isLoggedIn:Boolean = false;
 
  constructor(private signUpService : SignUpServiceService,
    private formBuilder : FormBuilder,
    private routerNav:Router ) {this.signUpForm = this.formBuilder.group (
    {
      nickName : '',
      email : ''
    }
  ) }

  ngOnInit() {
  }

  onSubmit(userToAdd:User) {

    // request for user creation to user service
    userToAdd.authority = null;
    userToAdd.publicationlist = null;
    this.signUpService.createUser(userToAdd).subscribe(
      user => { alert ('User ' + user.nickName + ' created');
      let key = 'nickName';
      localStorage.setItem(key,JSON.stringify(userToAdd.nickName));
      this.isLoggedIn = true;
      // Got to PublicationList with Login provided on top-bar
      this.routerNav.navigate(['publications-list']);},
      err => alert("No creation Error")
    );
    
  }

}
