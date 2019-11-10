import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';
import { OccasionWithInitiator } from '../models/OccasionWithInitiator';


@Injectable({
  providedIn: 'root'
})
export class OccasionServiceService {
  private serverUrl = 'http://192.168.178.43:8080/users' // Url of server witch receive the request
  constructor(private http: HttpClient){} // initialisation of client object) { }

  occasionList: OccasionWithInitiator [];

  getOccasionList(): OccasionWithInitiator[] {
    this.occasionList = this.getOccasions(JSON.parse(sessionStorage.getItem('currentUser')).id).subscribe(data => {return data;});
    console.log("das hier steht im Array"+ this.occasionList);
    return this.occasionList;
  }

  getOccasions(id: number):any{
     //Http Header
  
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json'
      })
    };

     // Postrequest
      return this.http.get<any>('http://localhost:8080/occasionsByPreferences?userId='+id, httpOptions);

  }

  postOccasion(occasionWithInitiator: OccasionWithInitiator){
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json'
      })
    };

    return this.http.post<OccasionWithInitiator>('http://localhost:8080/occasions',occasionWithInitiator, httpOptions);
  }
}
