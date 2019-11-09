import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OccasionWithInitiator } from 'src/app/models/OccasionWithInitiator';

@Component({
  selector: 'app-occasion',
  templateUrl: './occasion.component.html',
  styleUrls: ['./occasion.component.css']
})
export class OccasionComponent implements OnInit {
  @Input() occasion: OccasionWithInitiator;
  @Output() swipe: EventEmitter<OccasionWithInitiator> = new EventEmitter();
  constructor() { 
  
  }

  onSwipeRight($event){
    alert('Wisch nach rechts')
  }
  onSwipeLeft(occasion: OccasionWithInitiator, $event){
    alert('Wisch nach links')
    this.swipe.emit(occasion)
  }
  

  ngOnInit() {
  }

}
