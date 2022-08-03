import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User, UserDto, UserEditDto } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  username: string;
  username$ = new BehaviorSubject<string>('');

  message$ = new BehaviorSubject<string>('');
  loginApi: string;
  signUpApi: string;
  userAPi: string;

  constructor(private http: HttpClient) {
    this.username='';
    this.loginApi = 'http://localhost:8282/login';
    this.signUpApi='http://localhost:8282/user';
    this.userAPi = 'http://localhost:8282/user/username';
  }

  isLoggedIn(): boolean{
    //check if the user is logged in or not.
    this.username = localStorage.getItem('username');
    //console.log(this.username);
    if(this.username == null)
        return false;
    return true;
  }

  login(username: string, password: string): Observable<User> {
    let encodedCredentials = btoa(username + ':' + password); //aGFycnk6cG90dGVyMTIz
    let httpOptions={
      headers : new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization' : 'basic ' + encodedCredentials
      })
    };

     return this.http.get<User>(this.loginApi, httpOptions);
  }

  signUp(userDto: UserDto):Observable<any> {
    return this.http.post(this.signUpApi, userDto);
  }

  getUserByUsername(credentials: string) : Observable<UserEditDto>{
    let httpOptions={
      headers : new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization' : 'basic ' + credentials
      })
    };
    return this.http.get<UserEditDto>(this.userAPi,httpOptions);
  }

}
