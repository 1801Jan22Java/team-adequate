import { Component, OnInit } from '@angular/core';
import { HttpService } from '../Http.service';
import { PopulateService } from '../populate.service';
import { Place } from '../place';
import { User } from '../user';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private httpService: HttpService,
              private populateService: PopulateService) { }

  ngOnInit() {
    this.listPlaces = this.populateService.populatePlaces();
  }

  populateAutocomplete() : void {
    this.listPlaces = [];
    this.httpService.autocomplete(this.searchValue).subscribe(data => { for(let entry in data['predictions']) {
                                                                        this.listPlaces.push(data['predictions'][entry]['description']);
                                                                      }});
  }

  populateSearchResults() : void {
    console.log(this.listPlaces[0]);
    this.httpService.searchPlaces(this.listPlaces[0],this.searchDistance,this.searchPrice).subscribe(data => console.log(data));
  }

  loadAutocomplete() : void {
    console.log(this.searchValue);
    console.log(this.listPlaces);
    if(this.searchValue.length > 2) {
      this.showAutocomplete = true;
      this.populateAutocomplete();
    } else {
      this.showAutocomplete = false;
    }
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

  //Search params
  searchId : string = "";
  searchValue : string = "";
  searchPeople : boolean = false;
  searchDistance : number = 10;
  searchPrice : number = 1;
  searchRating : number = 1;
  showAutocomplete : boolean = false;
  advancedToggle : boolean = true;
  advancedString : string = "► Advanced";
  searchPriceString : string = '$';
  // searchRatingString :string =  'Rating: &#x272F;';
  listUsers : User [] = [];
  listPlaces : string [] = [];
  listResultPlaces : Place [] = [];
}
