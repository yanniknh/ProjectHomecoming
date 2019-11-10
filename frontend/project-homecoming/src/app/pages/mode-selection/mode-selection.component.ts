import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mode-selection',
  templateUrl: './mode-selection.component.html',
  styleUrls: ['./mode-selection.component.css']
})
export class ModeSelectionComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  searchOccasions(){
    this.router.navigateByUrl('/locationSelection');
  }
  createOccasion(){
    this.router.navigateByUrl('/createOccasion');
  }

}
