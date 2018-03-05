import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import {Http, Headers, RequestOptions} from '@angular/http';

//const baseUrl : string = 'http://ec2-18-218-126-211.us-east-2.compute.amazonaws.com:8080/AdequateTravel/';
const baseUrl : string = 'http://localhost:8080/AdequateTravel/';
//http://localhost:8080/AdequateTravel/login

@Injectable()
export class HttpService {

  constructor(private http: HttpClient) { }

  test(): Observable<Object> {
    return this.http.get("https://maps.googleapis.com/maps/api/place/autocomplete/json?input=Paris&types=geocode&&key=AIzaSyA-cqeJ3xy8IXWiIffplTwOUqZODVvMBps");
  }

  login(username: string, password: string) : Observable<Object> {
      
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    console.log(username + " " + password);

    return this.http.post(baseUrl + 'login',
    JSON.stringify({email: username, password: password}),
    {headers: {'Content-Type': 'application/json'}}
    );
  }

  register(firstname: string, lastname:string, username: string, password: string) : Observable<Object> {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    
    return this.http.post(baseUrl + 'register',
    JSON.stringify({email: username, fname: firstname, lname: lastname, password: password}),
    {headers: {'Content-Type': 'application/json'}}
    );
  }
}