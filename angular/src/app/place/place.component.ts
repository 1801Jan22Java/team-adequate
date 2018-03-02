import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-place',
  templateUrl: './place.component.html',
  styleUrls: ['./place.component.css']
})
export class PlaceComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    for(var i = 4; i >= 1; i--) {
      this.numStars += ' &#x272F;';
    }
  }
  numStars : String = 'Rating';
  placeName : String = 'temp name';
  placeDesciption : String = 'There\'s not a thing in the world wrong with washing your brush. Anything you want to do you can do here. Just relax and let it flow. That easy. You have to allow the paint to break to make it beautiful. How do you make a round circle with a square knife? That\'s your challenge for the day. And just raise cain.'

}
