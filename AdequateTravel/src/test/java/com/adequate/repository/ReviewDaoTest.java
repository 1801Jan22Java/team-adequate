package com.adequate.repository;

import static org.junit.Assert.*; 

import java.time.LocalDate;
import java.sql.Date;

import org.junit.Test;

import com.adequate.beans.Review; 

public class ReviewDaoTest {

	
	@Test
	public void getReviewByIdTest() {
		ReviewDaoImpl rdi = new ReviewDaoImpl();
		assertNotNull(rdi.getReviewById(2));
	}
	
	@Test 
	public void getReviewByPlaceIdTest() {
		ReviewDaoImpl rdi = new ReviewDaoImpl();
		assertNotNull(rdi.getReviewsByPlace(rdi.getReviewById(2).getLocation().getPlaceId()));
		// long convoluted way of getting a placeID
	}
	
	@Test
	public void getReviewByPersonTest() {
		ReviewDaoImpl rdi = new ReviewDaoImpl();
		assertNotNull(rdi.getReviewsByPerson(3));
	}
	
	@Test
	public void addReviewTest() {
		ReviewDaoImpl rdi = new ReviewDaoImpl();
		Review fakeReview = rdi.getReviewById(2);
		int fakeReviewLocationId = fakeReview.getLocation().getLocationId();
		int fakeReviewUserId = fakeReview.getPerson().getPersonID();
		
		Review fakeReviewTwo = new Review(fakeReviewLocationId, "that's my truck", 
				Date.valueOf(LocalDate.now()), 2);
		rdi.addReview(fakeReviewTwo);
		assertNotNull(rdi.getReviewsByPerson(fakeReviewUserId));
	}
	
}
