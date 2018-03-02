package com.adequate.repository;

import java.util.List;

import com.adequate.beans.Person;

public interface PersonDao {
	
	public List<Person> getAllPeople();
	
	public Person getPersonById(int id);
	
	public void addPerson(Person p);

	
}
