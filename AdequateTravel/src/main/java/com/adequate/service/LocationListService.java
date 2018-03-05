package com.adequate.service;

import java.util.List;

import com.adequate.beans.LocationList;

public interface LocationListService {

	public List<LocationList> getLocationLists(int personID);
	
	public LocationList getLocationListById(int locationListId);
	
	public void addLocationList(LocationList ll);
	
}
