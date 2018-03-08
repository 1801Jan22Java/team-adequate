package com.adequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adequate.beans.Person;
import com.adequate.repository.PersonDao;

@Service("realPersonService")
public class RealPersonService implements PersonService {

	@Autowired
	private PersonDao personRepository;
	
	@Override
	public List<Person> getAllPeople() {
		return personRepository.getAllPeople();
	}
	
	@Override
	public List<Person> getPeopleLike(String query) {
		return personRepository.getLikeSearch(query);
	}

	@Override
	public Person getPersonById(int id) {
		return personRepository.getPersonById(id);
	}

	@Override
	public void addPerson(Person p) {
		personRepository.addPerson(p);
	}
	
	@Override
	public void updatePerson(Person p) {
		personRepository.updatePerson(p);
	}

	@Override
	public Integer getIdByEmail(String email) {
		return personRepository.getIdByEmail(email);
	}

}