package com.adequate.repository;

import java.util.List;

import com.adequate.beans.LocationList;

public interface LocationListDao {
	
	public List<LocationList> getAllLocationLists();
	
	public LocationList getLocationListById(int id);
	
	public void addLocationList(LocationList ll);

}
