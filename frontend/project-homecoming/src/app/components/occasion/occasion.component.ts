import { Component, OnInit, Input } from '@angular/core';
import { OccasionWithInitiator } from 'src/app/models/OccasionWithInitiator';

@Component({
  selector: 'app-occasion',
  templateUrl: './occasion.component.html',
  styleUrls: ['./occasion.component.css']
})
export class OccasionComponent implements OnInit {
  @Input() occasion: OccasionWithInitiator;

  constructor() { 
  
  }

  ngOnInit() {
  }

}
