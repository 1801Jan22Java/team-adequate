import { Component, OnInit, Input } from '@angular/core';
import { PopulateService } from '../populate.service';
import { Place } from '../place';
import { Review } from '../review';

@Component({
  selector: 'app-place',
  templateUrl: './place.component.html',
  styleUrls: ['./place.component.css']
})
export class PlaceComponent implements OnInit {

  constructor(private populateService : PopulateService) { }

  ngOnInit() {
    this.place = this.populateService.populatePlace();
    this.populateListReviews();
    this.createRatingString();
  }

  createRatingString() {
    for(var i = 0; i <= this.place.rating; i++) {
      this.ratingString += ' &#x272F;';
    }
  }

  populateListReviews() {
    this.listReviews = this.populateService.populateReviews();
  }

  listReviews : Review [] = [];
  place : Place;
  ratingString : string = 'Rating ';
}
