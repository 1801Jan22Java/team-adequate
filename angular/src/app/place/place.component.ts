import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-place',
  templateUrl: './place.component.html',
  styleUrls: ['./place.component.css']
})
export class PlaceComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  placeName : String = 'temp name';
  placeDesciption : String = 'Lorem ipsum';


}
