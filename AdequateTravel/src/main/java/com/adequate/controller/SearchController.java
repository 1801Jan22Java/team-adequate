package com.adequate.controller;

import com.adequate.api.*; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:4200")
@Controller("searchController")
@RequestMapping("/search")
public class SearchController {
	private final String  apiKey = "&key=AIzaSyAvaHh8JH7aOABXm2NQzO9OveT5VLNDQXU";
	private final String secondaryApiKey = "&key=AIzaSyA-cqeJ3xy8IXWiIffplTwOUqZODVvMBps";
	private final String apiKeyGeocode = "&key=AIzaSyA4k2FBjButfxabh_rgO6DbK7_LSBQN538";
	
	// place search has extra parameters we care about
	private String placeSearchPrefix = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=";
	private String placeDetailsPrefix = "https://maps.googleapis.com/maps/api/place/details/json?placeid=";
	private String autocompletePlacePrefix = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=";
	
	private String latLongPrefix = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	
	
	@RequestMapping(value="/autoComplete", method=RequestMethod.GET)
	public ResponseEntity<AutocompletePlaceTemplate> autoComplete(@RequestParam("query") String query){
		String url = autocompletePlacePrefix + query + apiKey;
		AutocompletePlaceTemplate autoCompletePlaceTemplate = AutocompletePlaceGetter.getAutocompletePlaceTemplate(url);
		return new ResponseEntity<>(autoCompletePlaceTemplate,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/placeDetailsSearch", method=RequestMethod.GET)
	public ResponseEntity<PlaceDetailsTemplate> placeDetails(@RequestParam("placeID") String placeID){
		String url = placeDetailsPrefix + placeID + apiKey;
		PlaceDetailsTemplate placeDetailsTemplate = PlaceDetailsGetter.getPlaceDetailsTemplate(url);
		return new ResponseEntity<>(placeDetailsTemplate,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/placeSearch", method=RequestMethod.GET)
	public ResponseEntity<PlaceSearchTemplate> placeSearch(@RequestParam("query") String query, 
			@RequestParam("distance") Integer distance, @RequestParam("price") Integer price){
		Integer meterDistance = 0;
		
		if(distance < 30)
			meterDistance = 1600 * distance; // conversion between miles and meters
		else
			meterDistance = 49990; // Places api has max radius of 50 000 meters
		
		String parameters = convertIdToLatLong(query) +"&radius="+meterDistance+"&maxPrice="+price;
		
		String url = placeSearchPrefix + parameters + apiKey;
		PlaceSearchTemplate placeSearchTemplate = PlaceSearchGetter.getPlaceSearchTemplate(url);
		return new ResponseEntity<>(placeSearchTemplate,HttpStatus.CREATED);
	}
	
	
	public String convertIdToLatLong(String query){
		String url = latLongPrefix + query + apiKeyGeocode;
		LatLong latLong = LatLongGetter.getLatLongTemplate(url);
		System.out.println(latLong.getLat() + "," + latLong.getLng());
		return latLong.getLat() + "," + latLong.getLng();
	}
	
	public String convertReferenceToLink(String reference) {
		return "";
	}

	
}
