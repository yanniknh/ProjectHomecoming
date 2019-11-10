import { Component, OnInit } from '@angular/core';
import { OccasionWithInitiator } from 'src/app/models/OccasionWithInitiator';

@Component({
  selector: 'app-confirmation-page',
  templateUrl: './confirmation-page.component.html',
  styleUrls: ['./confirmation-page.component.css']
})
export class ConfirmationPageComponent implements OnInit {

  matchedOccasion: OccasionWithInitiator;

  constructor() { }

  ngOnInit() {
    this.matchedOccasion = JSON.parse(sessionStorage.getItem('match'));
  }

}
