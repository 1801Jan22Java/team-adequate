package com.adequate.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adequate.beans.Person;

@Repository("personRepository")
public class PersonDaoImpl implements PersonDao{

	@Override
	public List<Person> getAllPeople() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		
	}

}
