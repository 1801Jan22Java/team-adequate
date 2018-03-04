package com.adequate.repository;

import java.util.List;

import com.adequate.beans.Review;

public interface ReviewDao {

	public List<Review> getAllReviews();

	public Review getReviewById(int id);

	public void addReview(Review r);

}
