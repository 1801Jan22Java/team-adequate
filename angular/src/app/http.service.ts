import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/Http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import {Http, Headers, RequestOptions} from '@angular/http';

//const baseUrl : string = 'http://ec2-18-218-126-211.us-east-2.compute.amazonaws.com:8080/AdequateTravel/';
const baseUrl : string = 'http://localhost:8080/AdequateTravel/';
//http://localhost:8080/AdequateTravel/login

@Injectable()
export class HttpService {

  constructor(private http: HttpClient) { }

  convertLatLong (description : string ) : Observable<Object> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    return this.http.get(baseUrl + 'search/conversion?query=' + description,
  {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}});
  }

  searchPlace(id : string ) : Observable<Object> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    return this.http.get(baseUrl + 'search/placeDetailsSearch?placeID=' + id,
  {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}});
  }

  searchPlaces(description : string, keyword : string, distance : number, price : number ) : Observable<Object> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    return this.http.get(baseUrl + 'search/placeSearch?query=' + description + "&keyword=" + keyword + "&distance=" + distance + "&price=" + price,
  {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}});
  }

  autocomplete(query : string) : Observable<Object> {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    return this.http.get(baseUrl + 'search/autoComplete?query=' + query,
  {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}});
  }

  login(username: string, password: string) : Observable<Object> {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    console.log(username + " " + password);

    return this.http.post(baseUrl + 'login',
    JSON.stringify({email: username, password: password}),
    {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}}
    );
  }

  register(firstname: string, lastname:string, username: string, password: string) : Observable<Object> {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    console.log(firstname + password + lastname + username)
    return this.http.post(baseUrl + 'register',
    JSON.stringify({email: username, fname: firstname, lname: lastname, password: password}),
    {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}}
    );
  }

  logout(){
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    console.log("logout")
    return this.http.get(baseUrl + 'logout',
    {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}}
    );
  }

  validateUser(){

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    return this.http.get(baseUrl + 'validate',
    {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}}
    );

  }

  submitReview(rating : number, review : string, placeID : string){
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    console.log("Submitting review: " + review + " " + rating);

    return this.http.post(baseUrl + 'review/submit',
    JSON.stringify({rating: rating, review: review, placeID: placeID}),
    {headers: {'Content-Type': 'application/json'}}
    );
  }

  getReviews(placeId : string){
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    console.log("get Reviews")
    return this.http.get(baseUrl + 'review/byPlace?placeID=' + placeId,
    {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}}
    );
  }

  retrieveUserInfo() : Observable<Object>{

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    return this.http.get(baseUrl + 'account',
    {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}}
    );
  }

  updateAccountInfo(username : string, firstname : string, lastname : string, description : string, userImg : File) : Observable<Object> {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    console.log("Submitting account info for: " + username + ' desc' + description);
    //Profile image uploading is currently disabled because it needs a couple hours of figuring out
    //which are better spent elsewhere

    /*
      private String email;
      private String fname;
      private String lname;
      private String desc;
      private Blob img;
    */

    return this.http.post(baseUrl + 'account',
    JSON.stringify({email:username, fname:firstname, lname:lastname, desc:description/*, img: userImg*/}),
    {headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin':'*', 'responseType': 'application/json'}}
    );
  }
}
