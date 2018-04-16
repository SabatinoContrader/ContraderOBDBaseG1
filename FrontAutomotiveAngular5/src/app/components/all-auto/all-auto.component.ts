import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-auto',
  templateUrl: './all-auto.component.html',
  styleUrls: ['./all-auto.component.css']
})
export class AllAutoComponent implements OnInit {
  lat: number = 41.134769;
  lng: number = 14.780548;

  constructor() { }

  ngOnInit() {
    
  }

}
