package com.adequate.service;

import java.util.List;

import com.adequate.beans.Itinerary;

public interface ItineraryService {

	public List<Itinerary> getItineraries(int personID);
	
	public Itinerary getItineraryById(int itineraryID);
	
	public void addItinerary(Itinerary i);
	
}
