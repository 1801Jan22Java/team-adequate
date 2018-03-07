package com.adequate.api;

import org.springframework.web.client.RestTemplate;

public class LatLongGetter {
	
	public static void main(String [] args) {
		
		LatLong r = getLatLongTemplate("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyA4k2FBjButfxabh_rgO6DbK7_LSBQN538");
		System.out.println(r.toString());
		
	}

	
	public static LatLong getLatLongTemplate(String url) {
		RestTemplate restTemplate = new RestTemplate();
		LatLongTemplate resultLatLongTemplate = restTemplate.getForObject(url, LatLongTemplate.class);
		return resultLatLongTemplate.getResults()[0].getGeometry().getLocation();
	}

}
