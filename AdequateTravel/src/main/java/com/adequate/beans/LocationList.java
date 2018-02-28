package com.adequate.beans;

import java.util.List;

public class LocationList {

	private int locationID;
	private int userID; // user that created the list
	private String listName;
	private List<String> places; // placeIDs used by Google's PlacesAPI

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public List<String> getPlaces() {
		return places;
	}

	public void setPlaces(List<String> places) {
		this.places = places;
	}

	public int getLocationID() {
		return locationID;
	}

	public int getUserID() {
		return userID;
	}

}
