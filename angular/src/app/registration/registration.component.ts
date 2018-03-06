import { Component, OnInit } from '@angular/core';
import { HttpService } from '../Http.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private httpService: HttpService) { }

  regusername : string;
  regpassword : string;
  regfirstname : string;
  reglastname : string;
  invalidEmail : boolean = true;

  ngOnInit() {
  }

  register(){
    this.httpService.register(this.regfirstname, this.reglastname, this.regusername, this.regpassword).subscribe(data => console.log("reged: "));
    }
}
