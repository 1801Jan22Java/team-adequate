package com.adequate.controller;
import com.adequate.api.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adequate.api.AutocompletePlaceTemplate;


@CrossOrigin(origins = "http://localhost:4200")
@Controller("searchController")
@RequestMapping("/search")
public class SearchController {
	private final String apiKey = "&key=AIzaSyA4k2FBjButfxabh_rgO6DbK7_LSBQN538";
	
	// place search has extra parameters we care about
	private String placeSearchPrefix = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=";
	private String placeDetailsPrefix = "https://maps.googleapis.com/maps/api/place/details/json?placeid=";
	// add type=geocode afterwards input
	private String autocompletePlacePrefix = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=";
	
	@RequestMapping(value="/autoComplete", method=RequestMethod.GET)
	public ResponseEntity<AutocompletePlaceTemplate> autoComplete(@RequestParam("query") String query){
		String url = autocompletePlacePrefix + query + apiKey;
		
		AutocompletePlaceTemplate autoCompletePlaceTemplate = AutocompletePlaceGetter.getAutocompletePlaceTemplate(url);
		return new ResponseEntity<>(autoCompletePlaceTemplate,HttpStatus.CREATED);
	}
	
}
