package com.adequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adequate.beans.Person;
import com.adequate.repository.PersonDao;

@Service("personService")
public class RealPersonService implements PersonService {

	@Autowired
	private PersonDao personRepository;
	
	@Override
	public List<Person> getAllPeople() {
		return personRepository.getAllPeople();
	}

	@Override
	public Person getPersonById(int id) {
		return personRepository.getPersonById(id);
	}

	@Override
	public void addPerson(Person p) {
		personRepository.addPerson(p);
		
	}

}