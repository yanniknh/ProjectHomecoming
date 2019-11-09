import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-group-size-selection',
  templateUrl: './group-size-selection.component.html',
  styleUrls: ['./group-size-selection.component.css']
})
export class GroupSizeSelectionComponent implements OnInit {

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
  }
  
  onClick(option: number){
    this.userService.updateGroupPreferences(option);
    this.router.navigateByUrl('/timeSelection');
  }

}
