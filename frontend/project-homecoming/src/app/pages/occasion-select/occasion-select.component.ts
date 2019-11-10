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
  completeOccasionList: any =[];
  occasion: OccasionWithInitiator;
  i: number;

  constructor(private occassionService: OccasionServiceService) {
    
   }

  ngOnInit() {
    console.log("Fuer die UserID: "+JSON.parse(sessionStorage.getItem('currentUser')).id+" werden die moeglichen occasions gesucht");
    this.occassionService.getOccasions(JSON.parse(sessionStorage.getItem('currentUser')).id).subscribe((data: {})=>{
      this.occasionList = data;
      this.completeOccasionList = data;
      this.i=0;
      this.occasionList = this.occasionList.filter( t => t.occasion.id === this.occasionList[this.i].occasion.id );
    })
    
  }

  removeOccasion(occasion: OccasionWithInitiator){
    this.occasion = occasion;
    if(this.i < this.completeOccasionList.length-1){
      this.i = this.i+1;
    this.occasionList = this.completeOccasionList.filter( t => t.occasion.id === this.completeOccasionList[this.i].occasion.id );
    }else{
      this.occasionList = this.completeOccasionList.filter( t => t.occasion.id === -1);
      alert("End reached");
    }
  }

}
