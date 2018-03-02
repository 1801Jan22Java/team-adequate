import { Component, OnInit } from '@angular/core';
import { User } from '../user'

@Component({
  selector: 'app-user-card',
  templateUrl: './user-card.component.html',
  styleUrls: ['./user-card.component.css']
})
export class UserCardComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  user : User = {
    id : 0,

    username : "username",
    firstname : "firstname",
    lastname : "lastname",
    description : "When things happen - enjoy them. They're little gifts. Let's do it again then, what the heck. Volunteering your time; it pays you and your whole community fantastic dividends. I'm going to mix up a little color. We’ll use Van Dyke Brown, Permanent Red, and a little bit of Prussian Blue. Just a happy little shadow that lives in there. We want to use a lot pressure while using no pressure at all.",
    profilePic : "http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg"
  };

}
