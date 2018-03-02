package com.adequate.beans;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="ITINERARY")
@Component(value="itinerary")
public class Itinerary {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="itineraryIdSequence")
	@SequenceGenerator(allocationSize=1, name="itineraryIdSequence", sequenceName="SQ_ITIN_ID")
	@Column(name="ITINERARY_ID")
	private int itineraryID;
	
	@ManyToMany
	@JoinTable(
				name = "ITINERARY_LOCATION",
				joinColumns = { @JoinColumn(name="ITINERARY_ID") },
				inverseJoinColumns = { @JoinColumn(name="LOCATION_ID") }
			)
	private List<Location> locations; // placeIDs , those used by Google's PlacesAPI
	
	@Column(name = "CATEGORIES")
	private String categories; // "bar", "campground", "museum", etc
	
	@Column(name = "PARAMETERS")
	private String parameters;
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;

	public int getItineraryID() {
		return itineraryID;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Person getUser() {
		return person;
	}

}
