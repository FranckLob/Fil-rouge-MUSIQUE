import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';
import { User } from './user';
import { Publication } from './publication';


@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http:HttpClient) { }


  // create user provided as parameter
checkUser(nickName:String) : Observable<User> {
  console.log("In CheckUser");
  return this.http.get<User>('http://localhost:8080/api/share_music/user/bynickname?nickName='+ nickName);
 }


}
