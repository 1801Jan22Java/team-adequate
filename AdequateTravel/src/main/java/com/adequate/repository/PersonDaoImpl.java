package com.adequate.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adequate.beans.Person;

@Repository("personRepository")
@Transactional
public class PersonDaoImpl implements PersonDao{

	@Autowired 
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPeople() {
		Session s = sessionFactory.getCurrentSession();
		List<Person> peopleList = s.createCriteria(Person.class).list();
		return peopleList;
	}

	@Override
	public Person getPersonById(int id) {
		Session s = sessionFactory.getCurrentSession();
		Person person = (Person) s.get(Person.class, id);
		return person;
	}

	@Override
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		
	}

}
