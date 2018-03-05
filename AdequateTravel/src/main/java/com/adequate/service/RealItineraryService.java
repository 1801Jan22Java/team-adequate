package com.adequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adequate.beans.Itinerary;
import com.adequate.repository.ItineraryDao;

public class RealItineraryService implements ItineraryService {

	@Autowired 
	private ItineraryDao itineraryRepository;
	
	@Override
	public List<Itinerary> getItineraries(int personID) {
		return itineraryRepository.getItineraries(personID);
	}

	@Override
	public Itinerary getItineraryById(int itineraryID) {
		return itineraryRepository.getItineraryById(itineraryID);
	}

	@Override
	public void addItinerary(Itinerary i) {
		itineraryRepository.addItinerary(i);

	}

}
