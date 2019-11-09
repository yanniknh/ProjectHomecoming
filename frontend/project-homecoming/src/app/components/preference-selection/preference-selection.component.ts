import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-preference-selection',
  templateUrl: './preference-selection.component.html',
  styleUrls: ['./preference-selection.component.css']
})
export class PreferenceSelectionComponent implements OnInit {

  constructor() { }

  user: User;
  ngOnInit() {

  }

  ngOnSubmit(any){
    let number= 0;
    any.forEach(element => {
      this.user.preference[number] = element;

    });
  }

}
