package com.adequate.api;

import org.springframework.web.client.RestTemplate;

public class PlaceSearchGetter {
	
	public static void main(String [] args) {
		
		PlaceSearchTemplate r = getPlaceSearchTemplate("https://maps.googleapis.com/maps/api/place/textsearch/json?query=paris&key=AIzaSyA-cqeJ3xy8IXWiIffplTwOUqZODVvMBps");
		System.out.println(r.toString());
		
	}
	
	
	public static PlaceSearchTemplate getPlaceSearchTemplate(String url) {
		RestTemplate restTemplate = new RestTemplate();
		PlaceSearchTemplate resultPlaceSearchTemplate = restTemplate.getForObject(url, PlaceSearchTemplate.class);
		return resultPlaceSearchTemplate;
	}
}
