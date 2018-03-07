package com.adequate.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="LOCATION")
@Component(value="location")
public class Location {
	
	public Location(String placeId) {
		super();
		this.placeId = placeId;
		this.itineraries = new ArrayList<Itinerary>();
		this.locationLists = new ArrayList<LocationList>();
		this.reviews = new ArrayList<Review>();
	}

	public Location() {
		super();
		this.placeId = "";
		this.itineraries = new ArrayList<Itinerary>();
		this.locationLists = new ArrayList<LocationList>();
		this.reviews = new ArrayList<Review>();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="locationIdSequence")
	@SequenceGenerator(allocationSize=1, name="locationIdSequence", sequenceName="SQ_LIST_ID")
	@Column(name="LOCATION_ID")
	private int locationId;
	
	@Column(name="PLACEID")
	private String placeId; //The place id used by Google Places API
	
	@ManyToMany(mappedBy="locations")
	private List<LocationList> locationLists;
	
	@ManyToMany(mappedBy="locations")
	private List<Itinerary> itineraries;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Review> reviews;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public List<LocationList> getLocationLists() {
		return locationLists;
	}

	public void setLocationLists(List<LocationList> locationLists) {
		this.locationLists = locationLists;
	}

	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}
