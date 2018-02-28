import { Component, OnInit } from '@angular/core';
import { User } from '../user'

@Component({
  selector: 'app-account-page',
  templateUrl: './account-page.component.html',
  styleUrls: ['./account-page.component.css']
})
export class AccountPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  //Placeholder, load this from the backend
  user : User = {
    id : 0,

    username : "username",
    firstname : "firstname",
    lastname : "lastname",
    description : "This is a test description for the user"
  };

}
