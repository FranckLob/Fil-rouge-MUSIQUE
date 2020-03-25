import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {

  userLogin:String;
  isLoggedIn: Boolean = false;

  constructor() { }

  ngOnInit() {

        // Read user's Login if exists
        let key = 'nickName';
        this.userLogin = JSON.parse(localStorage.getItem(key));
    
         if (localStorage.length > 0) {
          this.isLoggedIn = true;
         }
    
  }

  disconnect(){
      localStorage.clear();
      this.isLoggedIn = false;
  }
}
