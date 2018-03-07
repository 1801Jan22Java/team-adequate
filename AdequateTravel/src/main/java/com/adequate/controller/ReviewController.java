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
import com.adequate.beans.Review;
import com.adequate.service.LocationService;
import com.adequate.service.PersonService;
import com.adequate.service.ReviewService;
import com.adequate.util.CurrentUser;

class MockReview {
	
	public MockReview() {
		super();
	}
	
	public MockReview(Integer rating, String review, String placeID) {
		super();
		this.rating = rating;
		this.review = review;
		this.placeID = placeID;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
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

	Integer rating;
	String review;
	String placeID;

}

@CrossOrigin(origins = "http://localhost:4200")
@Controller("reviewController")
@RequestMapping("/review")
public class ReviewController {

	//@Autowired
	private ReviewService realReviewService;

	//@Autowired
	private LocationService realLocationService;
	
	//@Autowired
	private PersonService realPersonService;

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createReview(@RequestBody MockReview mockReview) {

		// Get user who wrote the mockReview from the session in current user
		if (CurrentUser.getValidSession()) {
			
			Location l = realLocationService.getLocationByPlaceId(mockReview.getPlaceID());
			// if location doesn't yet exist in database, create new 
			if(realLocationService.getLocationByPlaceId(mockReview.getPlaceID()) == null) {
				realLocationService.addLocation(new Location(mockReview.getPlaceID()));
				l = realLocationService.getLocationByPlaceId(mockReview.getPlaceID());
				realReviewService.addReview(new Review(l.getLocationId(), CurrentUser.getUserID(), 
						mockReview.getReview(), Date.valueOf(LocalDate.now()), mockReview.getRating()));
			} else { // use existing location 
				realReviewService.addReview(new Review(l.getLocationId(), CurrentUser.getUserID(), 
						mockReview.getReview(), Date.valueOf(LocalDate.now()), mockReview.getRating()));
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
	public ResponseEntity<List<Review>> getReviewsByPlace(@RequestParam("placeID") String placeID){
		List<Review> placeReviews = realReviewService.getReviewsByPlace(placeID);
		return new ResponseEntity<List<Review>>(placeReviews, HttpStatus.OK);
	}
	
	@RequestMapping(value="/byPerson", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Review>> getReviewsByPerson(@RequestParam("email") String email){
		Integer personID = realPersonService.getIdByEmail(email);
		List<Review> personReviews = realReviewService.getReviewsByPerson(personID);
		return new ResponseEntity<List<Review>>(personReviews, HttpStatus.OK);
	}

}
