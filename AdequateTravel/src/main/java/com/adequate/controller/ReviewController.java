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

@CrossOrigin(origins = "http://localhost:4200")
@Controller("reviewController")
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private ReviewService realReviewService;
	//We also need to pass the place somehow (id?)
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createReview(@RequestBody Review review){
		
		//Get user who wrote the review from the session in current user
		//Be sure to validate session + user is not null
		
		System.out.println(review.getRating() + review.getReviewBody());
		
		return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.ACCEPTED);
	}
	/*
	 * Object received for review created: { rating: number, review: string }
	 */
	
	

}
