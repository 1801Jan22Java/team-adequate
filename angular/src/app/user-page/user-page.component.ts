import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { PopulateService } from '../populate.service';
import { HttpService } from '../Http.service';
import { User } from '../user'
import { Place } from '../place';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  constructor(private httpService : HttpService,
              private populateService : PopulateService,
              private router: Router) { }

  ngOnInit() {
    this.populateUser();
  }

  populateUserHelper(result : Object) {
    console.log(result);
    let populate : User = {
      id : result['id'],
      username : result['email'],
      firstname : result['fname'],
      lastname : result['lname'],
      description : result['description'],
      profilePic : "https://tse4.mm.bing.net/th?id=OIP.dfuGcOmQ7cyBB2Zeuc8IQQHaHa&pid=Api"

    };
    this.user = populate;
    this.user['firstname'] = this.user['firstname'].charAt(0).toUpperCase() + this.user['firstname'].slice(1);
    this.user['lastname'] = this.user['lastname'].charAt(0).toUpperCase() + this.user['lastname'].slice(1);
    if (this.user['description'] == 'null') {
        this.user['description'] = 'I haven\'t set my bio yet :^)';
    }
  }

  populateUser() {
    this.httpService.searchUser(this.router.url.split('=')[1]).subscribe(data => this.populateUserHelper(data));
  }
  user : User = this.populateService.populateUsers()[0];
  listPlaces : Place [] = []

}
