package com.adequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adequate.beans.Review;
import com.adequate.repository.ReviewDao;

public class RealReviewService implements ReviewService {

	@Autowired
	private ReviewDao reviewRepository;

	@Override
	public List<Review> getReviewsByPerson(int personID) {
		return reviewRepository.getReviewsByPerson(personID);
	}

	@Override
	public List<Review> getReviewsByPlace(String placeID) {
		return reviewRepository.getReviewsByPlace(placeID);
	}

	@Override
	public Review getReviewById(int reviewID) {
		return reviewRepository.getReviewById(reviewID);
	}

	@Override
	public void addReview(Review r) {
		reviewRepository.addReview(r);
	}

}
