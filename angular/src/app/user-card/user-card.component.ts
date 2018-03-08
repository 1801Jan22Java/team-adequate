import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-card',
  templateUrl: './user-card.component.html',
  styleUrls: ['./user-card.component.css']
})
export class UserCardComponent implements OnInit {

  @Input() user : User;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onClick(){

    if(this.user == null){
      //This shouldnt happen
      //Punish them
      console.log("Invalid place card!");
      this.router.navigateByUrl('/login');
    }
    else{
    //Redirect to the place page and submit the id of the place to load reqired information?
    console.log("Go to a better place!");
    this.router.navigateByUrl('/user?id=' + this.user.id);
    }
  }

}
