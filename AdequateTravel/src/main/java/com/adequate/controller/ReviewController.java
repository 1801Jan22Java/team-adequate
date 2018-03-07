package com.adequate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adequate.beans.Location;
import com.adequate.beans.Review;
import com.adequate.service.LocationService;
import com.adequate.service.PersonService;
import com.adequate.service.RealLocationService;
import com.adequate.service.RealPersonService;
import com.adequate.service.RealReviewService;
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

	@Autowired
	private ReviewService realReviewService;

	@Autowired
	private LocationService realLocationService;
	
	@Autowired
	private PersonService personService;

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
						mockReview.getReview(), LocalDate.now(), mockReview.getRating()));
			} else { // use existing location 
				realReviewService.addReview(new Review(l.getLocationId(), CurrentUser.getUserID(), 
						mockReview.getReview(), LocalDate.now(), mockReview.getRating()));
			}
			
			
		}
		// Be sure to validate session + user is not null

		return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.ACCEPTED);
	}
	/*
	 * Object received for review created: { rating: number, review: string }
	 */

}
