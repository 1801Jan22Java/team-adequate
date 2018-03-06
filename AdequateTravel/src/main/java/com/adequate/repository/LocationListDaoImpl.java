package com.adequate.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adequate.beans.LocationList;

@Repository("locationListRepository")
@Transactional
public class LocationListDaoImpl implements LocationListDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LocationList> getAllLocationLists(int personID) {
		Session s = sessionFactory.openSession();
		Criteria c = s.createCriteria(LocationList.class);
		List<LocationList> lll = c.list();
		s.close();
		return lll;
	}

	@Override
	public LocationList getLocationListById(int id) {
		Session s = sessionFactory.openSession();
		LocationList ll = (LocationList) s.get(LocationList.class, id);
		s.close();
		return ll;
	}

	@Override
	public void addLocationList(LocationList ll) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(ll);
		tx.commit();
		s.close();
	}

}
