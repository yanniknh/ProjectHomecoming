import { Injectable } from '@angular/core';
import { User } from '../models/User';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private serverUrl = 'http://192.168.178.43:8080/users' // Url of server witch receive the request
  user: User;
  constructor(
    private _http: HttpClient // initialisation of client object
  )
  {
    if (sessionStorage.getItem('user') == null)
    {
      this.user = {
        name: null,
        age: null,
        phoneNumber: null,
        picture: null,
        city: null,
        preferences: []
      }
      sessionStorage.setItem('user', JSON.stringify(this.user));
    } else {
      this.user = JSON.parse(sessionStorage.getItem('user'));
    }
  }

  setUserPersonalInfo(name: string, phone: string, age: number) {
    this.user.name = name;
    this.user.phoneNumber = phone;
    this.user.age = age;
    sessionStorage.setItem('user', JSON.stringify(this.user));
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.createUser(this.user).subscribe(data => console.log(data));
    console.log(this.user);
  }
  

  getUser() {
    return sessionStorage.getItem('user');
  }
  
  public createUser(user: User): Observable<User> {

    // Http Header
  
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json'
      })
    };
     // Postrequest
     return this._http.post<User>('http://192.168.178.43:8080/users', user, httpOptions);
    }

    public getAllUsers() {
      // Http Header
      const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json'
      })
    }; 
     // GetRequest 
     return this._http.get<User[]>('${this.serverUrl}/get', httpOptions)
    }
  
   
    

  }