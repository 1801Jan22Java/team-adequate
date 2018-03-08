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
    console.log(this.place.placePictures[0]);
  }

  createRatingString() {
    for(var i = 0; i <= this.place.rating; i++) {
      this.ratingString += ' &#x272F;';
    }
  }

  ratingString : string = 'Rating ';

  onClick(){

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
