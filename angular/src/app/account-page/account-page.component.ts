import { Component, OnInit } from '@angular/core';
import { User } from '../user'
import { HttpService } from '../Http.service';

@Component({
  selector: 'app-account-page',
  templateUrl: './account-page.component.html',
  styleUrls: ['./account-page.component.css']
})
export class AccountPageComponent implements OnInit {

  constructor(private httpService: HttpService) { }

  ngOnInit() {
  }

  //Placeholder, load this from the backend
  user : User = {
    id : 0,

    username : "username",
    firstname : "firstname",
    lastname : "lastname",
    description : "This is a test description for the user",
    profilePic : "img.jpg"
  };

  //Hook this up to the backend
  updateInfo(){
    this.httpService.test().subscribe( data => console.log("retrieved: " + data['high']));
  }
}
