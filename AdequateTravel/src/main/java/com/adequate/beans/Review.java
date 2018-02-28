package com.adequate.beans;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component(value="review")
public class Review {

	public Review(int locationID, int userID, String reviewBody, LocalDate timeOfReview, int rating) {
		super();
		this.locationID = locationID;
		this.userID = userID;
		this.reviewBody = reviewBody;
		this.timeOfReview = timeOfReview;
		this.rating = rating;
	}

	private int reviewID;
	private int locationID;
	private int userID; // foreign key to the users
	private String reviewBody;
	private LocalDate timeOfReview;
	private int rating; // number of stars, 0-4. Using 1-5 would be heresy

	public int getReviewID() {
		return reviewID;
	}

	public int getLocationID() {
		return locationID;
	}

	public int getUserID() {
		return userID;
	}

	public String getReviewBody() {
		return reviewBody;
	}

	public LocalDate getTimeOfReview() {
		return timeOfReview;
	}

	public int getRating() {
		return rating;
	}

}
