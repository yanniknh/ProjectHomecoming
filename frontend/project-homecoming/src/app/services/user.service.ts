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
  currentUser: User;
  locationPreferences: number[] = [];

  constructor(
    private _http: HttpClient // initialisation of client object
  )
  {
    if (sessionStorage.getItem('user') == null)
    {
      this.user = {
        id: null,
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

  updateGroupPreferences(option: number){
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));

    //201 1on1, 202 Group Preference, 203 either
    if (option === 201) {
      this.currentUser.preferences = [201];
    } else if (option === 202) {
      this.currentUser.preferences = [202];
    } else if (option === 203) {
      this.currentUser.preferences = [201, 202];
    } else {
      console.log( "Es konnte keine Gruppenvorgabe gefunden werden" );
      return;
    }
    sessionStorage.setItem('currentUser', JSON.stringify(this.currentUser));
    this.changeGroupPreference(this.currentUser).subscribe(data => console.log(data));
    
  }

  updateLocationPreference(option: number)
  {
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));

    //101 Home, 102 Restraurant, 103 either
    if (option === 101) {
      this.currentUser.preferences = [101];
    } else if (option === 102) {
      this.currentUser.preferences = [102];
    } else if (option === 103) {
      this.currentUser.preferences = [101, 102];
    } else { 
      console.log( "Es konnte keine Location gefunden werden" );
      return;
    }
    sessionStorage.setItem('currentUser', JSON.stringify(this.currentUser));
    this.changeLocationPreference(this.currentUser).subscribe(data => console.log(data));
  }

  setUserPersonalInfo(name: string, phone: string, age: number) {
    this.user.name = name;
    this.user.phoneNumber = phone;
    this.user.age = age;
    sessionStorage.setItem('user', JSON.stringify(this.user));
    this.user = JSON.parse(sessionStorage.getItem('user'));

    console.log(this.user);

    this.createUser(this.user).subscribe(
      (currentUser: User) => {
        
        sessionStorage.setItem('currentUser', JSON.stringify(currentUser)); 
      }
      );
    //sessionStorage.setItem('currentUser', JSON.stringify(this.currentUser));
  }
  

  getUser() {
    return sessionStorage.getItem('user');
  }
  
  public changeGroupPreference(currentUser: User): Observable <any> {

    // Http Header
  
    console.log(currentUser);
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json'
      })
    };

     // Postrequest
      return this._http.post<User>('http://192.168.178.43:8080/updateNumberOfParticipants', currentUser, httpOptions);
  }

  public changeLocationPreference(currentUser: User): Observable <any> {

    // Http Header
  
    console.log(currentUser);
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json'
      })
    };

     // Postrequest
      return this._http.post<User>('http://192.168.178.43:8080/updateLocationPreferences', currentUser, httpOptions);
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
     return this._http.get<User[]>('http://192.168.178.43:8080/get', httpOptions)
    }
  
   
    

  }