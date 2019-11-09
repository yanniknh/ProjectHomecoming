import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';


@Injectable({
  providedIn: 'root'
})
export class OccasionServiceService {
  private serverUrl = 'http://192.168.178.43:8080/users' // Url of server witch receive the request
  constructor(private http: HttpClient){} // initialisation of client object) { }


  

  getOccasions(id: number):any{
     //Http Header
  
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json'
      })
    };

     // Postrequest
      return this.http.get<any>('http://192.168.178.43:8080/occasionsByPreferences?userId='+id, httpOptions);

  }
}
