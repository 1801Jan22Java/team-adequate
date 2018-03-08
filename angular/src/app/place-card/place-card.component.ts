import { Component, OnInit, Input } from '@angular/core';
import { Place } from '../place'
import { Router } from '@angular/router';

@Component({
  selector: 'app-place-card',
  templateUrl: './place-card.component.html',
  styleUrls: ['./place-card.component.css']
})
export class PlaceCardComponent implements OnInit {

  @Input() place : Place;

  constructor(private router: Router) { }

  ngOnInit() {
    this.createRatingString();
    this.convertImage();
  }

  createRatingString() {
    for(var i = 0; i <= this.place.rating; i++) {
      this.ratingString += ' &#x272F;';
    }
  }

  ratingString : string = 'Rating ';

  convertImage() {
    if (this.place.placePictures != null) {
      for(var i = 0; i < this.place.placePictures.length; i ++ ) {
        this.place.placePictures[i] =   "https://maps.googleapis.com/maps/api/place/photo?maxwidth=1000&maxheight=1000&photoreference=" + this.place.placePictures[i]['photo_reference'] + "&key=AIzaSyD6F8kL9qTLMah_akXPFJHCLSoH6k61Las";
      }
    } else {
      this.place.placePictures = ["http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg"];
    }

  }

  onClick(){
    
    console.log(this.place.id);
    if(this.place == null){
      //This shouldnt happen
      //Punish them
      console.log("Invalid place card!");
      this.router.navigateByUrl('/login');
    }
    else{
    //Redirect to the place page and submit the id of the place to load reqired information?
    console.log("Go to a better place!");
    this.router.navigateByUrl('/place?id=' + this.place.id);
    }
  }
}
