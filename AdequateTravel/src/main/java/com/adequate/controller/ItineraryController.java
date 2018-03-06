package com.adequate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adequate.beans.Itinerary;
import com.adequate.service.ItineraryService;
import com.adequate.util.CurrentUser;

@CrossOrigin(origins = "http://localhost:4200")
@Controller("itineraryController")
@RequestMapping("/itinerary")
public class ItineraryController {
	
	@Autowired
	private ItineraryService realItineraryService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Itinerary>> getItineraries(){
		
		List<Itinerary> trips = realItineraryService.getItineraries(CurrentUser.getUserID());
		return new ResponseEntity<List<Itinerary>>(trips, HttpStatus.OK);
		
	}

}
