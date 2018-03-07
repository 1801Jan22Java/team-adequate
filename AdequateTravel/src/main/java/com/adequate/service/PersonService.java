package com.adequate.service;

import java.util.List;

import com.adequate.beans.Person;

public interface PersonService {

	public List<Person> getAllPeople();

	public Person getPersonById(int id);

	public Integer getIdByEmail(String email);
	
	public void addPerson(Person p);

}
