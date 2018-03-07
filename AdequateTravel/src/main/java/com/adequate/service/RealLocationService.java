package com.adequate.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.adequate.beans.Location;
import com.adequate.repository.LocationDao;

public class RealLocationService implements LocationService {

	@Autowired
	private LocationDao locationRepository;
	
	@Override
	public Location getLocationByPlaceId(String placeId) {
		return locationRepository.getLocationByPlaceId(placeId);
	}

	@Override
	public Location getLocationByLocationId(int id) {
		return locationRepository.getLocationByLocationId(id);
	}

	@Override
	public void addLocation(Location l) {
		locationRepository.addLocation(l);
	}

}
