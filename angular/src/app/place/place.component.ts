import { Component, OnInit, Input } from '@angular/core';
import { PopulateService } from '../populate.service';
import { Place } from '../place';
import { Review } from '../review';
import { HttpService } from '../Http.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-place',
  templateUrl: './place.component.html',
  styleUrls: ['./place.component.css']
})
export class PlaceComponent implements OnInit {

  constructor(private populateService : PopulateService, private httpService: HttpService, private route: ActivatedRoute) { }

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

  placeID : number = -1;

  populateListReviews() {
    console.log("getting id");
    this.route.queryParamMap.subscribe(params => {
      this.placeID = params['id'];
    })

    console.log(this.placeID);

    //this.listReviews = this.populateService.populateReviews();
  }

  listReviews : Review [] = [];
  place : Place;
  ratingString : string = 'Rating ';


  rating : number = 3;
  review : string;
  reviewRatingString : string = 'Rating: &#x272F; &#x272F; &#x272F;';

  submitReview(){
    this.httpService.submitReview(this.rating, this.review, this.place.id);
  }

  changeRatingString() : void {
    this.reviewRatingString = 'Rating:';
    for(var i = this.rating; i >= 1; i--) {
      this.reviewRatingString += ' &#x272F;';
    }
  }
}
