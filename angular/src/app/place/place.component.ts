import { Component, OnInit, Input } from '@angular/core';
import { PopulateService } from '../populate.service';
import { Place } from '../place';
import { Review } from '../review';
import { HttpService } from '../Http.service';
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
    if (this.place.placePictures != null) {
      for(var i = 0; i < this.place.placePictures.length; i ++ ) {
        if (i < 4) {
          this.place.placePictures[i] = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=1000&maxheight=1000&photoreference=" + this.place.placePictures[i]['photo_reference'] + "&key=AIzaSyCGEQ_o177Hxt9jtdNNVbuJGoMGLcX8tY4";
        } else {
          delete this.place.placePictures[i];
        }
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
    this.httpService.getReviews(this.placeID).subscribe(data=>{
      console.log(data);
      for(let i in data ){
        let review : Review = new Review();
        review.rating = data[i]['rating'];
        review.review = data[i]['body'];
        review.firstname = data[i]['firstname'];
        review.lastname = data[i]['lastname'][0];
        this.listReviews.push(review);
        console.log(data[i]['rating'] + data[i]['body']);

      }
    });
  }

  placeID : string = "";
  listReviews : Review [] = [];
  place : Place;
  ratingString : string = 'Rating ';

  rating : number = 3;
  review : string;
  reviewRatingString : string = 'Rating: &#x272F; &#x272F; &#x272F;';

  submitReview(){
    this.httpService.submitReview(this.rating, this.review, this.place.id).subscribe( data => {
      console.log("Review Submitted");
    });
  }

  changeRatingString() : void {
    this.reviewRatingString = 'Rating:';
    for(var i = this.rating; i >= 1; i--) {
      this.reviewRatingString += ' &#x272F;';
    }
  }
}
