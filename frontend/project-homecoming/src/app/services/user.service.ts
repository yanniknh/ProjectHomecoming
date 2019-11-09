import { Injectable } from '@angular/core';
import { User } from '../models/User';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private serverUrl = 'http://localhost:8080/users' // Url of server witch receive the request

  constructor(
    private _http: HttpClient // initialisation of client object
  ) { }

  public createUser(user: User): Observable<User> {

    // Http Header 
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json'
      })
    }; 
     // Postrequest 
     return this._http.post<User>(`${this.serverUrl}/add`, user, httpOptions)
    
    }

    public getAllUsers(){
      // Http Header 
      const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json'
      })
    }; 
     // GetRequest 
     return this._http.get<User[]>(`${this.serverUrl}/get`, httpOptions)
    }

    

  }