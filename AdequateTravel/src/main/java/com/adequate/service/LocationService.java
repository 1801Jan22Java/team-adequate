package com.adequate.service;

import com.adequate.beans.Location;

public interface LocationService {
	public Location getLocationByPlaceId(String placeId);
	
	public Location getLocationByLocationId(int id);
	
	public void addLocation(Location l);
}
