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
      description : result['about'],
      profilePic : "https://tse4.mm.bing.net/th?id=OIP.dfuGcOmQ7cyBB2Zeuc8IQQHaHa&pid=Api"

    };
    this.user = populate;
  }

  populateUser() {
    this.httpService.searchUser(this.router.url.split('=')[1]).subscribe(data => this.populateUserHelper(data));
  }
  user : User = this.populateService.populateUsers()[0];
  listPlaces : Place [] = []

}
