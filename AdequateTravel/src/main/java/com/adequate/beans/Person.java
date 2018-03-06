package com.adequate.beans;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Person", uniqueConstraints = {
		@UniqueConstraint(columnNames = "PERSON_EMAIL")
})
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
	
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Column(name="LAST_NAME")
	private String lastname;
	
	@Column(name="ABOUT")
	private String about;
	
	@Column(name="PERSON_IMAGE")
	@Lob
	private byte[] image;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Itinerary> itineraries;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LocationList> locationLists;
	
	public Person() {
		super();
	}
	
	public Person(String email, String password, String firstname, String lastname, String about, byte[] image) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.about = about;
		this.image = image;
	}
	
	public Person(String email, String password, String firstName, String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstName;
		this.lastname = lastName;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
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
