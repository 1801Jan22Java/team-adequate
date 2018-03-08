import { Component, OnInit, Input } from '@angular/core';
import { PopulateService } from '../populate.service';
import { User } from '../user'
import { Place } from '../place';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  //@Input() user : User; //TODO: ???? ashould have input or pull from DB?????

  constructor(private populateService: PopulateService) { }

  ngOnInit() {
    this.user = this.populateService.populateUsers()[0];
    // this.listPlaces = this.populateService.populatePlaces();
  }
  user : User;
  listPlaces : Place [] = []

}
