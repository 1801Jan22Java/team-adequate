package com.adequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adequate.beans.LocationList;
import com.adequate.repository.LocationListDao;

public class RealLocationListService implements LocationListService {

	@Autowired
	private LocationListDao locationListRepository;

	@Override
	public List<LocationList> getLocationLists(int personID) {
		return locationListRepository.getAllLocationLists(personID);
	}

	@Override
	public LocationList getLocationListById(int locationListId) {
		return locationListRepository.getLocationListById(locationListId);
	}

	@Override
	public void addLocationList(LocationList ll) {
		locationListRepository.addLocationList(ll);
	}

}
