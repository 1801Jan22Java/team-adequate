package com.adequate.api;

import org.springframework.web.client.RestTemplate;

public class PlaceSearchGetter {

	public static void main(String [] args) {
		
		PlaceSearchTemplate r = getPlaceSearchTemplate("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&keyword=food&key=AIzaSyAvaHh8JH7aOABXm2NQzO9OveT5VLNDQXU");
		System.out.println(r.toString());
		
	}

	
	public static PlaceSearchTemplate getPlaceSearchTemplate(String url) {
		RestTemplate restTemplate = new RestTemplate();
		PlaceSearchTemplate resultPlaceSearchTemplate = restTemplate.getForObject(url, PlaceSearchTemplate.class);
		return resultPlaceSearchTemplate;
	}
}
