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
  }
  onclickHotel() {this.searchCategory="hotel";}
  onclickNightClub() {this.searchCategory="night_club";}
  onclickShopping() {this.searchCategory="shopping";}
  onclickMuseum() {this.searchCategory="museum";}
  onclickBars() {this.searchCategory="bars";}
  onclickFood(){this.searchCategory="food";}

  populateAutocompleteHelper(data : Object) : void {
    for(let entry in data) {
      console.log(data[entry]['description']);
      console.log("greetings");
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
    if (!this.searchPeople) {
      this.listPlaces = [];
      this.httpService.autocomplete(this.searchValue).subscribe(data => {console.log(data);this.populateAutocompleteHelper(data['predictions'])});
      console.log(this.listPlaces);
    }
  }

  populateSearchResultsHelper(listResults : Object []) : Place [] {
    console.log(listResults);
    var placeList : Place [] = [];
    for(let result in listResults) {
      var place : Place = {
        id : listResults[result]['place_id'],
        rating :  listResults[result]['rating'],
        description : listResults[result]['name'],
        placeTypes :  listResults[result]['types'],
        placePictures :  listResults[result]['photos'],

      };
      console.log(place);
      placeList.push(place);
    }
    return placeList;
  }

  populateSearchResults() : void {
    console.log(this.listPlaces[0]['description']);
    this.listResultPlaces = [];
    this.httpService.searchPlaces(this.listPlaces[0]['description'].replace(' ','+'),this.searchCategory,this.searchDistance,this.searchPrice).subscribe(data => this.listResultPlaces = this.populateSearchResultsHelper(data['results']));
    console.log(this.listResultPlaces);
  }

  populateSearchPeopleHelper(results : Object){
    for(var i in results) {
      console.log(results[i]);
      let user : User = {
        id : results[i]['personID'],
        username : results[i]['email'],
        firstname : results[i]['firstname'],
        lastname : results[i]['lastname'],
        description : results[i]['about'],
        profilePic : "http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg"
      };
      this.listUsers.push(user);
    }
  }
  populateSearchPeople() : void {
    this.listUsers = [];
    this.httpService.searchUsers(this.searchValue).subscribe(data => {this.populateSearchPeopleHelper(data);});
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
  listUsers : User [] = [];
  listPlaces : Place [] = [];
  listResultPlaces : Place [] = [];
}
