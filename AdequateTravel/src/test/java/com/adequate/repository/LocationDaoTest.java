package com.adequate.repository;

import static org.junit.Assert.*; 
import org.junit.Test;

import com.adequate.beans.Location;

public class LocationDaoTest {

	@Test
	public void getLocationByLocationIdTest() {
		LocationDaoImpl ldi = new LocationDaoImpl();
		assertNotNull(ldi.getLocationByLocationId(1));
	}
	
	@Test
	public void getLocationByPlaceIdTest() {
		LocationDaoImpl ldi = new LocationDaoImpl();
		assertNotNull(ldi.getLocationByPlaceId(ldi.getLocationByLocationId(1).getPlaceId()));
	}
	
	@Test
	public void addLocationTest() {
		Location fake = new Location("fakeLocation");
		LocationDaoImpl ldi = new LocationDaoImpl();
		ldi.addLocation(fake);
		assertNotNull(ldi.getLocationByPlaceId("fakeLocation"));
	}
}
