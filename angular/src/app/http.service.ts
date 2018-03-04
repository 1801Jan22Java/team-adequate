import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

@Injectable()
export class HttpService {

  constructor(private http: HttpClient) { }

  test(): Observable<Object> {
    return this.http.get("https://maps.googleapis.com/maps/api/place/autocomplete/json?input=Paris&types=geocode&&key=AIzaSyA-cqeJ3xy8IXWiIffplTwOUqZODVvMBps");
  }

}
