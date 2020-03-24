import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { User } from '../user';
import {SignUpServiceService} from '../sign-up-service.service';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signUpForm;

  constructor(private signUpService : SignUpServiceService,
    private formBuilder : FormBuilder) {this.signUpForm = this.formBuilder.group (
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
      user => { alert ("User " + user + "Created")}
    );
    
    // clean user creation form once creation completed
    this.signUpForm.reset();
    console.warn('After reset ', userToAdd);
  }

}
