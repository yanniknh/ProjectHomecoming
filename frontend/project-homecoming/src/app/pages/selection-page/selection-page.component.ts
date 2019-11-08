import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-selection-page',
  templateUrl: './selection-page.component.html',
  styleUrls: ['./selection-page.component.css']
})
export class SelectionPageComponent implements OnInit {

  status: String;

  constructor() { }

  ngOnInit() {
    this.status = '!isOn';
  }


}
