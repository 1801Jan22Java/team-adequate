package com.adequate.beans;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Person")
@Component(value="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="personIdSequence")
	@SequenceGenerator(allocationSize=1, name="personIdSequence",sequenceName="SQ_NEW_PERSON_ID")
	@Column(name="PERSON_ID")
	private int personID;
	
	@Column(name="PERSON_EMAIL")
	private String email;
	
	@Column(name="PERSON_PASSWORD")
	private String password;
	
	@OneToOne(mappedBy="person", cascade = CascadeType.ALL)
	private PersonInfo personInfo;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Itinerary> itineraries;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LocationList> locationLists;
	
	public Person() {
		super();
	}
	
	public Person(String email, String password, PersonInfo personInfo) {
		super();
		this.email = email;
		this.password = password;
		this.personInfo = personInfo;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPersonID() {
		return personID;
	}
	public String getEmail() {
		return email;
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
}
