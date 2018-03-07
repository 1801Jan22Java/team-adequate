package com.adequate.api;

import java.util.Arrays;

class PlaceSearchResult {
	private String name;
	private String place_id;
	private String rating;
	private Photo [] photos;
	private String[] types;

	public PlaceSearchResult() {
		super();
	}

	public PlaceSearchResult(String name, String place_id, Photo [] photos, String rating, String[] types) {
		super();
		this.name = name;
		this.place_id = place_id;
		this.rating = rating;
		this.photos = photos;
		this.types = types;
	}
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public Photo [] getPhotos() {
		return photos;
	}

	public void setPhotos(Photo [] photos) {
		this.photos = photos;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "PlaceSearchResult [name=" + name + ", place_id=" + place_id + ", rating=" + rating +", photos=" + photos + ", types="
				+ Arrays.toString(types) + "]";
	}

}

public class PlaceSearchTemplate {

	private PlaceSearchResult[] results;
	
	public PlaceSearchTemplate() {
		super();
	}

	public PlaceSearchTemplate(PlaceSearchResult[] results) {
		super();
		this.results = results;
	}

	public PlaceSearchResult[] getResults() {
		return results;
	}

	public void setResults(PlaceSearchResult[] results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "PlaceSearchTemplate [results=" + Arrays.toString(results) + "]";
	}
	
}
