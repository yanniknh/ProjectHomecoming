import { Component, OnInit, Injectable } from '@angular/core';
import { OccasionWithInitiator } from 'src/app/models/OccasionWithInitiator';
import { UserService } from 'src/app/services/user.service';
import { OccasionServiceService } from 'src/app/services/occasion-service.service';

@Component({
  selector: 'app-occasion-select',
  templateUrl: './occasion-select.component.html',
  styleUrls: ['./occasion-select.component.css']
})
@Injectable(
  {
    providedIn: 'root',
  })

  
export class OccasionSelectComponent implements OnInit {
  occasionList: any = [];
  occasion: OccasionWithInitiator;

  constructor(private occassionService: OccasionServiceService) {
    
   }

  ngOnInit() {
    console.log(JSON.parse(sessionStorage.getItem('currentUser')).id)
    this.occassionService.getOccasions(JSON.parse(sessionStorage.getItem('currentUser')).id).subscribe((data: {})=>{
      this.occasionList = data;
      console.log(data);
    });
  }

  removeOccasion(occasion: OccasionWithInitiator){
    console.log(occasion.occasion)
    this.occasionList.filter( t => t.occasion.id !== occasion.occasion.id );
  }

}
