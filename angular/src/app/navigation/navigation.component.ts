import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private router: Router, private httpService: HttpService) { }

  ngOnInit() {
    console.log("Check logged in...");
    this.httpService.validateUser().subscribe(
        data => {
        if(data['status'] == 'success'){
          console.log("User is valid!");
        }
        else{
          //Invalid user, redirect to home
          this.router.navigateByUrl('/login');
        }
    })
  }

  logout(){

    this.httpService.logout().subscribe( data => this.router.navigateByUrl('/login'));

  }
}
