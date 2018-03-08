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

    this.user = new User;
    this.httpService.retrieveUserInfo().subscribe(data => {

      if(data['status'] == 'success'){
        this.user.firstname = data['fname'];
        this.user.lastname = data['lname'];
        this.user.username = data['email'];
        this.user.description = data['description'];
        this.user.id = data['id'];
      }
      else{
        this.user.firstname = 'Invalid';
        this.user.lastname = 'Invalid';
        this.user.username = 'Invalid';
        this.user.description = 'Invalid';
        this.user.id = -1;
      }

      //user.profilePic = data['img'];
    });

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
    console.log( this.user.firstname);
    //var reader = new FileReader();

    let file : File = document.getElementById("changeProfilePicture")['files'][0];

    //Slice converts file to a blob; only do this if file has been chosen
    if(file != null)
      this.userImg = file.slice();

      //console.log(URL.createObjectURL(file));
    //this.userImg = document.getElementById("changeProfilePicture")['files'][0];
    //console.log(this.userImg);
    //console.log(this.userImg);
   // let reader = new FileReader();
   // reader.readAsText();

    this.httpService.updateAccountInfo(this.user.username, this.user.firstname, this.user.lastname, this.user.description, file).subscribe(
      data => console.log("account info update sent")
    );
  }
}
