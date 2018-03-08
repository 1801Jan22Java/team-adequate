package com.adequate.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adequate.beans.Itinerary;
import com.adequate.service.ItineraryService;
import com.adequate.util.CurrentUser;


@CrossOrigin(origins = "http://localhost:4200")
@Controller("itineraryController")
@RequestMapping("/itinerary")
public class ItineraryController {
	
	private final String apiKey = "&key=AIzaSyA-cqeJ3xy8IXWiIffplTwOUqZODVvMBps";
	
	// place search has extra parameters we care about
	private String placeSearchPrefix = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=";
	
	@Autowired
	private ItineraryService realItineraryService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Itinerary>> getItineraries(){
		
		List<Itinerary> trips = realItineraryService.getItineraries(CurrentUser.getUserID());
		return new ResponseEntity<List<Itinerary>>(trips, HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Itinerary> makeNewItinerary(){
		return null;
	}
	

}
