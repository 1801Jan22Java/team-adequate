package com.adequate.beans;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="PERSONINFO")
@Component(value="personInfo")
public class PersonInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2306627404984231025L;

	@Id
	@OneToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;
	
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Column(name="LAST_NAME")
	private String lastname;
	
	@Column(name="ABOUT")
	private String about;
	
	@Column(name="PERSON_IMAGE")
	@Lob
	private byte[] image;

	public PersonInfo() {
		super();
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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

	public int getPersonID() {
		return person.getPersonID();
	}

}
