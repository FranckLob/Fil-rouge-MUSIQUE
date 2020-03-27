import { Component, OnInit } from '@angular/core';
import { IsLoggedInService } from '../is-logged-in.service';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {

  userLogin:String;
 

  constructor(private isLoggedInservice: IsLoggedInService) {
    isLoggedInservice.userLogin = this.isLoggedInservice.userLogin;
   }

  ngOnInit() {
  }

  disconnect(){
      localStorage.clear();
      this.isLoggedInservice.ngOnInit();
  }

}
