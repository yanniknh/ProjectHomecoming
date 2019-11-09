import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-location-selection',
  templateUrl: './location-selection.component.html',
  styleUrls: ['./location-selection.component.css']
})
export class LocationSelectionComponent implements OnInit {

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
  }
  
  onClick(option: number) {
    // 101 home
    // 102 auswaerts
    this.userService.updateLocationPreference(option);
    this.router.navigateByUrl('/groupSelection');
  }

}
