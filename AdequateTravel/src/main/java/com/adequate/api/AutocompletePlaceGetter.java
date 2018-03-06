package com.adequate.api;

import org.springframework.web.client.RestTemplate;

public class PlaceGetter {
	
	public static void main(String [] args) {
		
		PlaceTemplate r = getPlaceTemplate("https://maps.googleapis.com/maps/api/place/autocomplete/json?input=paris&types=geocode&&key=AIzaSyA-cqeJ3xy8IXWiIffplTwOUqZODVvMBps");
		System.out.println(r.toString());
		
	}
	
	public static PlaceTemplate getPlaceTemplate(String url) {
		RestTemplate restTemplate = new RestTemplate();
		PlaceTemplate resultPlaceTemplate = restTemplate.getForObject(url, PlaceTemplate.class);
		return resultPlaceTemplate;
	}

}
