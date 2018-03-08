package com.adequate.api;

import java.util.Arrays;

import org.springframework.web.client.RestTemplate;


public class PlaceDetailsGetter {

	public static void main(String [] args) {
		
		PlaceDetailsTemplate r = getPlaceDetailsTemplate("https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJN1t_tDeuEmsRUsoyG83frY4&key=AIzaSyAvaHh8JH7aOABXm2NQzO9OveT5VLNDQXU");
		System.out.println(r.toString());
		
	}
	
	public static PlaceDetailsTemplate getPlaceDetailsTemplate(String url) {
		RestTemplate restTemplate = new RestTemplate();
		PlaceDetailsTemplate resultPlaceDetailsTemplate = restTemplate.getForObject(url, PlaceDetailsTemplate.class);
		return resultPlaceDetailsTemplate;
	}

}
