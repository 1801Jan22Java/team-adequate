package com.adequate.repository;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adequate.beans.Location;
import com.adequate.beans.LocationList;

@Repository("locationRepository")
@Transactional
public class LocationDaoImpl implements LocationDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Location getLocationByPlaceId(String placeId) {
		Session s = sessionFactory.openSession();
		Criteria c = s.createCriteria(Location.class)
				.add(Restrictions.eq("place_id", placeId));
		try {
			Location l = (Location) c.list().get(0);
			s.close();
			return l;
		} catch (ArrayIndexOutOfBoundsException e) {
			s.close();
			return null;
		}
		
	}

	@Override
	public Location getLocationByLocationId(int id) {
		Session s = sessionFactory.openSession();
		Location l = (Location) s.get(LocationList.class, id);
		s.close();
		return l;
	}

	@Override
	public void addLocation(Location l) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(l);
		
		tx.commit();
		
		s.close();
	}

}
