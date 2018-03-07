import { Injectable } from '@angular/core';
import { User } from './user';
import { Place } from './place';
import { Review } from './review';
import { HttpService } from './http.service';

@Injectable()
export class PopulateService {

  constructor(private httpService: HttpService) { }

  populatePlace() : Place {
    var place : Place = {
      id : "",
      rating :  0,
      description :'There\'s not a thing in the world wrong with washing your brush. Anything you want to do you can do here. Just relax and let it flow. That easy. You have to allow the paint to break to make it beautiful. How do you make a round circle with a square knife? That\'s your challenge for the day. And just raise cain.',
      placeTypes : [],
      placePictures : ["http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg"],

    };
    return place;
  }

  populatePlaces(listResults : Object []) : Place [] {
    console.log(listResults);
    var placeList : Place [] = [];
    for(let result in listResults) {
      var place : Place = {
        id : listResults[result]['place_id'],
        rating :  0,
        description : listResults[result]['name'],
        placeTypes :  listResults[result]['types'],
        placePictures :  listResults[result]['photos'],

      };
      console.log(place);
      placeList.push(place);
    }
    return placeList;

  }
  populateReview() : Review {
    var review : Review = {
      id : 1,
      rating : 2,
      username : "username",
      firstname : "firstname",
      lastname : "lastname",
      review : "When things happen - enjoy them. They're little gifts. Let's do it again then, what the heck. Volunteering your time; it pays you and your whole community fantastic dividends. I'm going to mix up a little color. We’ll use Van Dyke Brown, Permanent Red, and a little bit of Prussian Blue. Just a happy little shadow that lives in there. We want to use a lot pressure while using no pressure at all.",
      profilePic : "http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg"
    };
    return review;

  }
  populateReviews() : Review [] {
    var reviewList : Review [] = [];
    for(var i = 0; i < 6; i ++ ) {
      var review : Review = {
        id : 1,
        rating : 2,
        username : "username",
        firstname : "firstname",
        lastname : "lastname",
        review : "When things happen - enjoy them. They're little gifts. Let's do it again then, what the heck. Volunteering your time; it pays you and your whole community fantastic dividends. I'm going to mix up a little color. We’ll use Van Dyke Brown, Permanent Red, and a little bit of Prussian Blue. Just a happy little shadow that lives in there. We want to use a lot pressure while using no pressure at all.",
        profilePic : "http://weknowmemes.com/wp-content/uploads/2013/11/doge-original-meme.jpg"
      };
      reviewList.push(review);
    }
    return reviewList;

  }

  populateUsers() {
    var userList : User [] = [];
    for(var i = 0; i < 4; i ++) {
      var  user : User = {
          id : 0,

          username : "username",
          firstname : "firstname",
          lastname : "lastname",
          description : "This is a test description for the user",
          profilePic :"https://tse4.mm.bing.net/th?id=OIP.dfuGcOmQ7cyBB2Zeuc8IQQHaHa&pid=Api"
        };
      userList.push(user);
    }
    return userList;
  }

  populateAccount() {
    var  user : User = {
        id : 0,

        username : "Account username",
        firstname : "firstname",
        lastname : "lastname",
        description : "This is a test description for the user",
        profilePic : "https://tse4.mm.bing.net/th?id=OIP.dfuGcOmQ7cyBB2Zeuc8IQQHaHa&pid=Api"
      };
    return user;
  }


}
