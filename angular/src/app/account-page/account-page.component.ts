import { Component, OnInit } from '@angular/core';
import { User } from '../user'
import { Place } from '../place';
import { HttpService } from '../http.service';
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
    // this.listPlaces = this.populateService.populatePlaces();

    //Set the bound variables to loaded in user
  }

  //Placeholder, load this from the backend
  user : User;
  listPlaces : Place [] = [];

  username : string;
  firstname : string;
  lastname : string;
  description : string;
  userImg : Blob;

  //Hook this up to the backend
  updateInfo(){
    //console.log(this.userImg);
    //var reader = new FileReader();

    let file : File = document.getElementById("changeProfilePicture")['files'][0];
    if(file != null)
      this.userImg = file.slice();

      //console.log(URL.createObjectURL(file));
    //this.userImg = document.getElementById("changeProfilePicture")['files'][0];
    //console.log(this.userImg);
    //console.log(this.userImg);
   // let reader = new FileReader();
   // reader.readAsText();
    this.httpService.updateAccountInfo(this.username, this.firstname, this.lastname, this.description, file).subscribe(
      data => console.log("todo")
    );
  }
}
