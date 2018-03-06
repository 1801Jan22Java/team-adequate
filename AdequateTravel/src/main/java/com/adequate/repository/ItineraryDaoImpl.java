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

import com.adequate.beans.Itinerary;

@Repository("itineraryRepository")
@Transactional
public class ItineraryDaoImpl implements ItineraryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Itinerary> getItineraries(int personID) {
		Session s = sessionFactory.openSession();
		Criteria c = s.createCriteria(Itinerary.class)
				.add(Restrictions.eq("person_id", personID));
		List<Itinerary> is = c.list();
		s.close();
		return is;
	}

	@Override
	public Itinerary getItineraryById(int itineraryID) {
		Session s = sessionFactory.openSession();
		Itinerary i = (Itinerary) s.get(Itinerary.class, itineraryID);
		s.close();
		return i;
	}

	@Override
	public void addItinerary(Itinerary i) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(i);
		tx.commit();
		s.close();
	}

}
