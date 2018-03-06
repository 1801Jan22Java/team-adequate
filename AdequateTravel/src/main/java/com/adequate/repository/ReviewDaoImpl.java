package com.adequate.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adequate.beans.Review;

@Repository("reviewRepository")
@Transactional
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getReviewsByPerson(int personID) {
		Session s = sessionFactory.openSession();
		Criteria c = s.createCriteria(Review.class)
				.add(Restrictions.eq("person_id", personID));
		List<Review> rs = c.list();
		s.close();
		return rs;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getReviewsByPlace(String placeID) {
		Session s = sessionFactory.openSession();
		Criteria c = s.createCriteria(Review.class)
				.add(Restrictions.eq("placeid", placeID));
		List<Review> rs = c.list();
		s.close();
		return rs;
	}

	@Override
	public Review getReviewById(int id) {
		Session s = sessionFactory.openSession();
		Review r = (Review) s.get(Review.class, id);
		s.close();
		return r;
	}

	@Override
	public void addReview(Review r) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(r);
		tx.commit();
		s.close();
	}

}
