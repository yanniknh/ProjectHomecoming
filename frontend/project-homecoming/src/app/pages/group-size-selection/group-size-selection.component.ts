import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-group-size-selection',
  templateUrl: './group-size-selection.component.html',
  styleUrls: ['./group-size-selection.component.css']
})
export class GroupSizeSelectionComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  
  next(){
    this.router.navigateByUrl('/timeSelection');
  }

}
