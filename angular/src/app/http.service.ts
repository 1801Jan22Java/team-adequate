import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

const baseUrl : string = 'http://ec2-18-218-126-211.us-east-2.compute.amazonaws.com:8080/AdequateTravel';

@Injectable()
export class HttpService {

  constructor(private http: HttpClient) { }

  test(): Observable<Object> {
    return this.http.get("https://maps.googleapis.com/maps/api/place/autocomplete/json?input=Paris&types=geocode&&key=AIzaSyA-cqeJ3xy8IXWiIffplTwOUqZODVvMBps");
  }

  login(username: string, password: string) : Observable<Object> {
    console.log(username + " " + password);
    return this.http.post(baseUrl + 'login', "username:" + username + "password:" + password);
  }
}