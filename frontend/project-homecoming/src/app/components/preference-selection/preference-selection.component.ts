import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-preference-selection',
  templateUrl: './preference-selection.component.html',
  styleUrls: ['./preference-selection.component.css']
})
export class PreferenceSelectionComponent implements OnInit {

  constructor() { }

  numberOfPreferences: number;
  user: User;
  ngOnInit() {
    this.numberOfPreferences = 0;
    this.user = new User();
    this.user.preferences = [];
  }



  onClick(preferenceID: number){
    this.user.preferences[this.numberOfPreferences] = preferenceID;
    this.numberOfPreferences ++;
    console.log(this.user.preferences);
  }

  ngOnSubmit(){
    if(this.numberOfPreferences = 0){
      alert('Es wurde keine Auswahl getroffen')
    }
    else{
      sessionStorage.setItem('user',JSON.stringify(this.user));
    }
  }
  


}
