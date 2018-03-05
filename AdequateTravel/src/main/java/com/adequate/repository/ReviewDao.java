package com.adequate.repository;

import java.util.List;

import com.adequate.beans.Review;

public interface ReviewDao {

	public List<Review> getReviewsByPerson(int personID);
	
	public List<Review> getReviewsByPlace(String placeID);

	public Review getReviewById(int id);

	public void addReview(Review r);

}
