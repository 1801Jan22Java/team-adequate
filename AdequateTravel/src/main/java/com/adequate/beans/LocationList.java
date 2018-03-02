package com.adequate.beans;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="LOCATIONLIST")
@Component(value="locationList")
public class LocationList {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="locationListIdSequence")
	@SequenceGenerator(allocationSize=1, name="locationListIdSequence",sequenceName="SQ_LOCATION_LIST_ID_PK")
	@Column(name="LOCATION_LIST_ID")
	private int locationID;
	@Column(name="LIST_NAME")
	private String listName;
	
	@ManyToMany
	@JoinTable(
				name="LOCATION_RELATION",
				joinColumns = { @JoinColumn(name="LOCATION_LIST_ID") },
				inverseJoinColumns = { @JoinColumn(name="LOCATION_ID") }
			)
	private List<Location> locations; // placeIDs used by Google's PlacesAPI
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person; // user that created the list

	public int getLocationID() {
		return locationID;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Person getPerson() {
		return person;
	}

}
