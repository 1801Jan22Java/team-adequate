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
    this.checkUrl();
  }

  username : string;
  password : string;
  successRegister : boolean = false;
  failedLogin : boolean = false;

  checkUrl() : void {
    if (this.router.url.split('=')[1]) {
      this.successRegister = true;
    }
    console.log(this.router.url.split('=')[1]);
  }


  //Hook this up to the backend
  login(){
    this.successRegister = false;
    this.httpService.login(this.username, this.password).subscribe( data => {if(data['status'] == 'success'){
      this.router.navigateByUrl('/home');
    }
    else{
      this.failedLogin = true;
    }
  }

  );
  }
}
