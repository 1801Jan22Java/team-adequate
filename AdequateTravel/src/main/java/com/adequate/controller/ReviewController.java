package com.adequate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adequate.beans.Review;

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

	// We also need to pass the place somehow (id?)
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createReview(@RequestBody Review review) {

		// Get user who wrote the review from the session in current user
		if (CurrentUser.getValidSession()) {

		}
		// Be sure to validate session + user is not null

		System.out.println(review.getRating() + review.getReviewBody());

		return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.ACCEPTED);
	}
	/*
	 * Object received for review created: { rating: number, review: string }
	 */

}
