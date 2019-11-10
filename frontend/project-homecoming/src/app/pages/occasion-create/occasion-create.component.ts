import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { Occasion } from 'src/app/models/Occasion';
import { OccasionWithInitiator } from 'src/app/models/OccasionWithInitiator';
import { OccasionServiceService } from 'src/app/services/occasion-service.service';

@Component({
  selector: 'app-occasion-create',
  templateUrl: './occasion-create.component.html',
  styleUrls: ['./occasion-create.component.css']
})
export class OccasionCreateComponent implements OnInit {

  user:User;
  occasion: Occasion;
  occasionWithInitiator: OccasionWithInitiator;

  constructor(private occasionService: OccasionServiceService) { }

  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('currentUser'));
    this.occasion = new Occasion();
    this.occasionWithInitiator = new OccasionWithInitiator();
  }

  onSubmit(any){
    this.occasionWithInitiator.initiator = this.user;
    this.occasion.description = any.description;
    this.occasion.picture = any.picture;
    this.occasion.title = any.title;
    this.occasionWithInitiator.occasion = this.occasion;
    console.log(this.occasionWithInitiator);
    this.occasionService.postOccasion(this.occasionWithInitiator).subscribe(
      (occasion: OccasionWithInitiator) => {
        
        console.log(occasion);
      }
      );
  }

}
