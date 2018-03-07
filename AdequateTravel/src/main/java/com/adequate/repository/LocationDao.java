package com.adequate.repository;

import com.adequate.beans.Location;

public interface LocationDao {
	public Location getLocationByPlaceId(String placeId);
	
	public Location getLocationByLocationId(int id);
	
	public void addLocation(Location l);
}
