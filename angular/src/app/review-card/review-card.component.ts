import { Component, OnInit } from '@angular/core';
import { Review } from '../review';

@Component({
  selector: 'app-review-card',
  templateUrl: './review-card.component.html',
  styleUrls: ['./review-card.component.css']
})
export class ReviewCardComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    for(var i = 4; i >= 1; i--) {
      this.ratingString += ' &#x272F;';
    }
  }
  ratingString : String = 'Rating:';
  review : Review = {
    id : 1,
    rating : 2,
    username : "username",
    firstname : "firstname",
    lastname : "lastname",
    review : "When things happen - enjoy them. They're little gifts. Let's do it again then, what the heck. Volunteering your time; it pays you and your whole community fantastic dividends. I'm going to mix up a little color. We’ll use Van Dyke Brown, Permanent Red, and a little bit of Prussian Blue. Just a happy little shadow that lives in there. We want to use a lot pressure while using no pressure at all.",
    profilePic : "http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg"
    };

    viewCard(){
      document.getElementById("reviewModalImage").setAttribute("src", this.review.profilePic);
      document.getElementById("reviewModalname").innerText =  this.review.firstname + " " + this.review.lastname[0] + ".";
      document.getElementById("reviewModalRating").innerHTML = this.ratingString.toString();
      document.getElementById("reviewModalreview").innerText = this.review.review;
    }
}
