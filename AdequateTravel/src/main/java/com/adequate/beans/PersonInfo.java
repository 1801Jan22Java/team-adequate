package com.adequate.beans;

import org.springframework.stereotype.Component;

@Component(value="userInfo")
public class PersonInfo {

	private int userID;
	private String firstname;
	private String lastname;
	private String about;

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

	public int getUserID() {
		return userID;
	}

}
