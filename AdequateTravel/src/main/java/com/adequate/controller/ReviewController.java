package com.adequate.controller;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adequate.beans.Location;
import com.adequate.beans.Person;
import com.adequate.beans.Review;
import com.adequate.service.LocationService;
import com.adequate.service.PersonService;
import com.adequate.service.ReviewService;
import com.adequate.util.CurrentUser;

class MockReview {
	
	private int rating;
	private String review;
	private String placeID;
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getPlaceID() {
		return placeID;
	}
	public void setPlaceID(String placeID) {
		this.placeID = placeID;
	}

}

@CrossOrigin(origins = "http://localhost:4200")
@Controller("reviewController")
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService realReviewService;

	@Autowired
	private LocationService realLocationService;
	
	@Autowired
	private PersonService realPersonService;
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createReview(@RequestBody MockReview mockReview) {

		System.out.println(mockReview.getPlaceID() + mockReview.getRating() + mockReview.getReview());
		// Get user who wrote the mockReview from the session in current user
		if (CurrentUser.getValidSession()) {
			
			Location l = realLocationService.getLocationByPlaceId(mockReview.getPlaceID());
			Person p = realPersonService.getPersonById(CurrentUser.getUserID());
			// if location doesn't yet exist in database, create new 
			if(realLocationService.getLocationByPlaceId(mockReview.getPlaceID()) == null) {
				realLocationService.addLocation(new Location(mockReview.getPlaceID()));
				l = realLocationService.getLocationByPlaceId(mockReview.getPlaceID());
				Review review = new Review(l.getLocationId(), mockReview.getReview(), Date.valueOf(LocalDate.now()), mockReview.getRating());
				review.setLocation(l);
				review.setPerson(p);
				realReviewService.addReview(review);
			} else { // use existing location 
				Review review = new Review(l.getLocationId(), mockReview.getReview(), Date.valueOf(LocalDate.now()), mockReview.getRating());
				review.setLocation(l);
				review.setPerson(p);
				realReviewService.addReview(review);
			}
			
		} else {
			return new ResponseEntity<>("{\"status\":\"invalid\"}", HttpStatus.OK);
		}

		return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.ACCEPTED);
	}
	/*
	 * Object received for review created: { rating: number, review: string }
	 */
	
	@RequestMapping(value="/byPlace", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getReviewsByPlace(@RequestParam("placeID") String placeID){
		List<Review> placeReviews = realReviewService.getReviewsByPlace(placeID);
		String jsonString = "[";
		
		for(int i = 0; i < placeReviews.size(); i++) {
			jsonString += "{\"rating\":\""+placeReviews.get(i).getRating()+"\",\"body\":\""+placeReviews.get(i).getReviewBody()+"\"";
			jsonString += "}";
			jsonString += i < placeReviews.size() - 1 ? "," : "";
		}
		
		jsonString += "]";
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/byPerson", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Review>> getReviewsByPerson(@RequestParam("email") String email){
		System.out.println("You shouldnt be here");
		Integer personID = realPersonService.getIdByEmail(email);
		List<Review> personReviews = realReviewService.getReviewsByPerson(personID);
		return new ResponseEntity<List<Review>>(personReviews, HttpStatus.OK);
	}

}
