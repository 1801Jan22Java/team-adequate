import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
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
  }

  populateAutocompleteHelper(data : Object) : void {
    for(let entry in data) {
      console.log(data[entry]['description']);
      console.log(data[entry]['rating']);
      var place : Place = {
        id : data[entry]['place_id'],
        rating : parseInt(data[entry]['rating']),
        description : data[entry]['description'],
        placeTypes : [],
        placePictures : []
      };
      this.listPlaces.push(place);

    }
  }

  populateAutocomplete() : void {
    this.listPlaces = [];
    this.httpService.autocomplete(this.searchValue).subscribe(data => {console.log(data);this.populateAutocompleteHelper(data['predictions'])});
    console.log(this.listPlaces);
  }

  populateSearchResultsHelper() : void {

  }

  populateSearchResults() : void {
    console.log(this.listPlaces[0]['description']);
    this.httpService.searchPlaces(this.listPlaces[0]['description'].replace(' ','+'),this.searchDistance,this.searchPrice).subscribe(data => this.listResultPlaces = this.populateService.populatePlaces(data['results']));
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

  setSearchCategory() : void {
    console.log(this.searchCategory)
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
  searchCategory : string = "";
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
  listPlaces : Place [] = [];
  listResultPlaces : Place [] = [];
}
