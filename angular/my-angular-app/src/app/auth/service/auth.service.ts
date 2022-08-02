import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  username: string;
  message$ = new BehaviorSubject<string>('');
  constructor() {
    this.username='';
  }

  isLoggedIn(): boolean{
    //check if the user is logged in or not.
    this.username = localStorage.getItem('username');
    //console.log(this.username);
    if(this.username == null)
        return false;
    return true;
  }
}
