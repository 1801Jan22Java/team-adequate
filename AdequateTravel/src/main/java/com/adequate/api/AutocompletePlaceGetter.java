package com.adequate.api;

import org.springframework.web.client.RestTemplate;

public class AutocompletePlaceGetter {
	

	public static void main(String [] args) {
		
		AutocompletePlaceTemplate r = getAutocompletePlaceTemplate("https://maps.googleapis.com/maps/api/place/autocomplete/json?input=paris&types=geocode&&key=AIzaSyA-cqeJ3xy8IXWiIffplTwOUqZODVvMBps");
		System.out.println(r.toString());
		
	}

	
	
	public static AutocompletePlaceTemplate getAutocompletePlaceTemplate(String url) {
		RestTemplate restTemplate = new RestTemplate();
		AutocompletePlaceTemplate resultPlaceTemplate = restTemplate.getForObject(url, AutocompletePlaceTemplate.class);
		return resultPlaceTemplate;
	}

}
