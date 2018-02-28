package com.adequate.beans;

import java.util.List;
import java.util.Map;

public class Itinerary {

	private int itineraryID;
	private List<String> places; // placeIDs , those used by Google's PlacesAPI
	private List<String> categories; // "bar", "campground", "museum", etc
	private Map<String, String> parameters;

	public List<String> getPlaces() {
		return places;
	}

	public void setPlaces(List<String> places) {
		this.places = places;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public int getItineraryID() {
		return itineraryID;
	}

}
