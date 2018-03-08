import { Component, OnInit, Input } from '@angular/core';
import { Review } from '../review';

@Component({
  selector: 'app-review-card',
  templateUrl: './review-card.component.html',
  styleUrls: ['./review-card.component.css']
})
export class ReviewCardComponent implements OnInit {

  @Input() review : Review;

  constructor() { }

  ratingString : String = 'Rating:';

  ngOnInit() {
    for(var i = 4; i >= 1; i--) {
      this.ratingString += ' &#x272F;';
    }
    this.review.profilePic = 'http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg';
    console.log(this.review);
  }


  viewCard(){
    document.getElementById("reviewModalImage").setAttribute("src", "http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg");
    document.getElementById("reviewModalname").innerText =  this.review.firstname + " " + this.review.lastname[0] + ".";
    document.getElementById("reviewModalRating").innerHTML = this.ratingString.toString();
    document.getElementById("reviewModalreview").innerText = this.review.review;
  }
}
