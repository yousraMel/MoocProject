import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private host = 'http://localhost:8082/apiUser';
  constructor(private http: HttpClient) { }

  signIn(user) {
    return this.http.post(this.host + '/signIn', user);
    }

  registration(user) {
     return this.http.post(this.host + '/registration', user);
  }



}
