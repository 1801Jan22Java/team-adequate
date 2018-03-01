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
    description : "This is a test description for the user",
    profilePic : "http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg"
  };

}
