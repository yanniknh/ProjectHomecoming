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
  checkPreference: boolean;
  ngOnInit() {
    this.numberOfPreferences = 0;
    this.user = new User();
    this.user.preferences = [];
  }



  onClick(preferenceID: number){
    this.user.preferences.forEach(element => {
      if(element == preferenceID){
        this.checkPreference = true;
      }
    });
    if(this.checkPreference == true){
      this.numberOfPreferences --;
      let number:number = 0;
      this.user.preferences.forEach(element => {
        if(element == preferenceID){
          this.user.preferences.splice(number,1);
        }
        number++;
      });

      
      alert('Erfolgreich abgewählt');
      this.checkPreference = false;
    }else{
      this.user.preferences[this.numberOfPreferences] = preferenceID;
    this.numberOfPreferences ++;
    console.log(this.user.preferences);
    alert('Erfolgreich ausgewählt');
    }
    
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
