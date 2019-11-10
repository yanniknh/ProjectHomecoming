import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-personal-information-registration',
  templateUrl: './personal-information-registration.component.html',
  styleUrls: ['./personal-information-registration.component.css']
})
export class PersonalInformationRegistrationComponent implements OnInit {
  createdUser: User;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    //this.createdUser = this.userService.getUser
  }

  onSubmit(any) {
    this.userService.setUserPersonalInfo(any.name, any.phoneNumber, any.age);
    this.router.navigateByUrl('/modeSelection');
  }
}
