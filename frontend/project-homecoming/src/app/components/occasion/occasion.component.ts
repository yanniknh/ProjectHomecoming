import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OccasionWithInitiator } from 'src/app/models/OccasionWithInitiator';

@Component({
  selector: 'app-occasion',
  templateUrl: './occasion.component.html',
  styleUrls: ['./occasion.component.css']
})
export class OccasionComponent implements OnInit {
  @Input() occasion: any;
  @Output() swipeLeft: EventEmitter<any> = new EventEmitter();
  @Output() swipeRight: EventEmitter<any> = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }
  
  onSwipeRight($events){
    alert('Wisch nach rechts');
    sessionStorage.setItem('match',JSON.stringify(this.occasion));
    console.log(this.occasion.occasion.title+ " wurde nach rechts gewischt");
    this.swipeRight.emit(JSON.stringify(this.occasion));

  }
  onSwipeLeft($event){
    alert('Wisch nach links');
    console.log(this.occasion.occasion.title+ " wurde nach links gewischt");
    this.swipeLeft.emit(JSON.stringify(this.occasion));
  }
  


}
