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
			// if location doesn't yet exist in database, create new 
			if(realLocationService.getLocationByPlaceId(mockReview.getPlaceID()) == null) {
				System.out.println("1");
				realLocationService.addLocation(new Location(mockReview.getPlaceID()));
				System.out.println("2");
				l = realLocationService.getLocationByPlaceId(mockReview.getPlaceID());
				System.out.println("3");
				Review review = new Review(l.getLocationId(), CurrentUser.getUserID(), mockReview.getReview(), Date.valueOf(LocalDate.now()), mockReview.getRating());
				System.out.println("4");
				review.setLocationList(l);
				System.out.println("5");
				realReviewService.addReview(review);
			} else { // use existing location 
				System.out.println("ded");
				Review review = new Review(l.getLocationId(), CurrentUser.getUserID(), mockReview.getReview(), Date.valueOf(LocalDate.now()), mockReview.getRating());
				review.setLocationList(l);
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
	public ResponseEntity<List<Review>> getReviewsByPlace(@RequestParam("placeID") String placeID){
		System.out.println("getting place");
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
