import { Component, OnInit, Input } from '@angular/core';
import { Place } from '../place'

@Component({
  selector: 'app-place-card',
  templateUrl: './place-card.component.html',
  styleUrls: ['./place-card.component.css']
})
export class PlaceCardComponent implements OnInit {

  @Input() place : Place;

  constructor() { }

  ngOnInit() {
    this.createRatingString();
  }

  createRatingString() {
    for(var i = 0; i <= this.place.rating; i++) {
      this.ratingString += ' &#x272F;';
    }
  }

  ratingString : string = 'Rating ';

}
