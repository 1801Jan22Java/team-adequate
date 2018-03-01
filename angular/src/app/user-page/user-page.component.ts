import { Component, OnInit } from '@angular/core';
import { User } from '../user'

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  user : User = {
    id : 0,

    username : "username",
    firstname : "firstname",
    lastname : "lastname",
    description : "This is a test description for the user",
    profilePic : "https://tse4.mm.bing.net/th?id=OIP.dfuGcOmQ7cyBB2Zeuc8IQQHaHa&pid=Api"
  };

}
