import { Component, OnInit } from '@angular/core';
import { HttpService } from '../Http.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private httpService: HttpService) { }

  ngOnInit() {
  }

  username : string;
  password : string;

  //Hook this up to the backend
  login(){
    this.httpService.login(this.username, this.password).subscribe( data => console.log("retrieved: " + data['high']));
  }
}
