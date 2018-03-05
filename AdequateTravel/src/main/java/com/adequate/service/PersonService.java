package com.adequate.service;

import java.util.List;

import com.adequate.beans.Person;

public interface PersonService {

	public List<Person> getAllPeople();

	public Person getPersonById(int id);

	public void addPerson(Person p);

}
