import { Component, OnInit } from '@angular/core';
import { HttpService } from '../Http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private httpService: HttpService) { }

  ngOnInit() {
  }

  username : string;
  password : string;

  //Hook this up to the backend
  login(){
    this.httpService.login(this.username, this.password).subscribe( data => {if(data['status'] == 'success'){
      this.router.navigateByUrl('/home');
    }
    else{
      console.log('you lose');
    }
  }

  );
  }
}
