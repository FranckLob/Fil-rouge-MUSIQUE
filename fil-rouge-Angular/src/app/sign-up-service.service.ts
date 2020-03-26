import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class SignUpServiceService {

  constructor(private http:HttpClient) { }


// create user provided as parameter
createUser(user:User) : Observable<User> {
  console.log("*****************");
  console.log(user);
  console.log('http://localhost:8080/api/share_music/user/')
  console.log("****************");

  return this.http.post <User>('http://localhost:8080/api/share_music/user/', user);
 }


}


