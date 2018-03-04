import { Component, OnInit } from '@angular/core';
import { Place } from '../place'

@Component({
  selector: 'app-place-card',
  templateUrl: './place-card.component.html',
  styleUrls: ['./place-card.component.css']
})
export class PlaceCardComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  place : Place = {
    id : 0,
    rating : 0,
    name : "temp name",
    description : "temp text",
    placePictures : [],
  };

}
