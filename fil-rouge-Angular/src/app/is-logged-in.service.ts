import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IsLoggedInService {


  userLogin;
  isLoggedIn : Boolean = false;;

  constructor() { 

  }
  ngOnInit() {
       // Read user's Login if exists
   let key = 'nickName';
   this.userLogin = JSON.parse(localStorage.getItem(key));
       
   if (localStorage.length > 0) {
      this.isLoggedIn = true;
   } else {
       this.isLoggedIn = false;
   }

  }


}

