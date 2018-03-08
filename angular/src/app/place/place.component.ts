import { Component, OnInit, Input } from '@angular/core';
import { PopulateService } from '../populate.service';
import { Place } from '../place';
import { Review } from '../review';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-place',
  templateUrl: './place.component.html',
  styleUrls: ['./place.component.css']
})
export class PlaceComponent implements OnInit {

  constructor(private populateService : PopulateService, private httpService: HttpService, private router: Router) { }

  ngOnInit() {
    this.populateListReviews();
    this.place = this.populateService.populatePlace();
    this.httpService.searchPlace(this.placeID).subscribe(data =>
    {
      console.log("HERERERERERER");
      console.log(data);
      // this.place.id = data[]
      this.place.id = this.placeID;
      this.place.description = data['result']['name'];
      this.place.placeTypes = data['result']['types'];
      this.place.placePictures = data['result']['photos'];
      this.place.rating = parseInt(data['result']['rating']);
      this.convertImage();
      console.log(this.place);
      this.createRatingString();
    });


  }

  convertImage() {
    for(var i = 0; i < this.place.placePictures.length; i ++ ) {
      // console.log(photo);
      if (i < 4) {
        this.place.placePictures[i] = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=1000&maxheight=1000&photoreference=" + this.place.placePictures[i]['photo_reference'] + "&key=AIzaSyD6F8kL9qTLMah_akXPFJHCLSoH6k61Las";
      } else {
        delete this.place.placePictures[i];
      }
    }
  }

  createRatingString() {
    for(var i = 0; i <= this.place.rating; i++) {
      this.ratingString += ' &#x272F;';
    }
  }

  populateListReviews() {
    console.log("getting id");
    console.log(this.router.url.split('=')[1]);
    this.placeID = this.router.url.split('=')[1];

  }

  placeID : string = "ii";
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
