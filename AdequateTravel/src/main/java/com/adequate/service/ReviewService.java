package com.adequate.service;

import java.util.List;

import com.adequate.beans.Review;

public interface ReviewService {

	public List<Review> getReviewsByPerson(int personID);
	
	public List<Review> getReviewsByPlace(String placeID);
	
	public Review getReviewById(int reviewID);
	
	public void addReview(Review r);
	
}
