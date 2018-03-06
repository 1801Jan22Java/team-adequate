import { Component, OnInit } from '@angular/core';
import { User } from '../user'
import { Place } from '../place';
import { HttpService } from '../Http.service';
import { PopulateService } from '../populate.service';

@Component({
  selector: 'app-account-page',
  templateUrl: './account-page.component.html',
  styleUrls: ['./account-page.component.css']
})
export class AccountPageComponent implements OnInit {

  constructor(private httpService: HttpService,
              private populateService: PopulateService) { }

  ngOnInit() {
    this.user = this.populateService.populateAccount();
    this.listPlaces = this.populateService.populatePlaces();
  }

  //Placeholder, load this from the backend
  user : User;
  listPlaces : Place [] = [];
  //Hook this up to the backend
  updateInfo(){
    this.httpService.test().subscribe( data => console.log("retrieved: " + data['high']));
  }
}
