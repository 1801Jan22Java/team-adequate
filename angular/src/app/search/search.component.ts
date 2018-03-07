import { Component, OnInit } from '@angular/core';
import { HttpService } from '../Http.service';
import { Place } from '../place';
import { User } from '../user';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private httpService: HttpService) { }

  ngOnInit() {
  }

  test():void{

  }

  toggleAdvanced() : void {
    if (this.advancedToggle) {
      this.advancedString = "▼ Advanced";
      this.advancedToggle = !this.advancedToggle;
    } else {
      this.advancedString = "► Advanced";
      this.advancedToggle = !this.advancedToggle;
    }
  }

  togglePeople() : void {
      this.searchPeople = !this.searchPeople
  }

  changePriceString() : void {
    this.searchPriceString = '';
    for(var i = this.searchPrice; i >= 1; i--) {
      this.searchPriceString += '$';
    }
  }

  changeRatingString() : void {
    this.searchRatingString = 'Rating:';
    for(var i = this.searchRating; i >= 1; i--) {
      this.searchRatingString += ' &#x272F;';
    }
  }


  //Search params
  searchPeople : boolean = true;
  searchDistance : number = 10;
  searchPrice : number = 1;
  searchRating : number = 1;
  advancedToggle : boolean = true;
  advancedString : string = "► Advanced";
  searchPriceString : string = '$';
  searchRatingString :string =  'Rating: &#x272F;';
  listUsers : User [] = [];
  listPlaces : Place [] = [];
}
