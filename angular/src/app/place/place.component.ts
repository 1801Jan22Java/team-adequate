import { Component, OnInit, Input } from '@angular/core';
import { PopulateService } from '../populate.service';
import { Place } from '../place';
import { Review } from '../review';
import { HttpService } from '../Http.service';

@Component({
  selector: 'app-place',
  templateUrl: './place.component.html',
  styleUrls: ['./place.component.css']
})
export class PlaceComponent implements OnInit {

  constructor(private populateService : PopulateService, private httpService: HttpService) { }

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


  rating : number = 3;
  review : string;
  reviewRatingString : string = 'Rating: &#x272F; &#x272F; &#x272F;';

  submitReview(){
    this.httpService.submitReview(this.rating, this.review);
  }

  changeRatingString() : void {
    this.reviewRatingString = 'Rating:';
    for(var i = this.rating; i >= 1; i--) {
      this.reviewRatingString += ' &#x272F;';
    }
  }
}
