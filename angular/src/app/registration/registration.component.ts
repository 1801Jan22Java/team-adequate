import { Component, OnInit } from '@angular/core';
import { HttpService } from '../Http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private router: Router, private httpService: HttpService) { }

  regusername : string;
  regpassword : string;
  regfirstname : string;
  reglastname : string;
  invalidEmail : boolean = true;

  ngOnInit() {
  }

  register(){
    this.httpService.register(this.regfirstname, this.reglastname, this.regusername, this.regpassword).subscribe(
      data => {if(data['status'] == 'success'){
        this.router.navigateByUrl('/login');
      }
      else{
        //TODO:: make something happen here to let user know they done messed up
        console.log('Invalid login!');
      }
    })
    }
}
