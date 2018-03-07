package com.adequate.beans;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="REVIEW")
@Component(value="review")
public class Review {

	public Review(int locationID, int userID, String reviewBody, LocalDate timeOfReview, int rating) {
		super();
		this.reviewBody = reviewBody;
		this.timeOfReview = timeOfReview;
		this.rating = rating;
	}
	
	public Review() {}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reviewIdSequence")
	@SequenceGenerator(allocationSize=1, name="reviewIdSequence",sequenceName="SQ_REVIEW_ID_PK")
	@Column(name="REVIEW_ID")
	private int reviewID;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="LOCATION_ID")
	private Location location;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSON_ID")
	private Person person; // foreign key to the users
	
	@Column(name="REVIEW_BODY")
	private String reviewBody;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "REVIEW_DATE")
	private LocalDate timeOfReview;
	
	@Column(name = "RATING")
	private int rating; // number of stars, 0-4.

	public int getReviewID() {
		return reviewID;
	}

	public Location getLocationList() {
		return location;
	}

	public void setLocationList(Location location) {
		this.location = location;
	}

	public String getReviewBody() {
		return reviewBody;
	}

	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}

	public LocalDate getTimeOfReview() {
		return timeOfReview;
	}

	public void setTimeOfReview(LocalDate timeOfReview) {
		this.timeOfReview = timeOfReview;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Person getPerson() {
		return person;
	}



}
