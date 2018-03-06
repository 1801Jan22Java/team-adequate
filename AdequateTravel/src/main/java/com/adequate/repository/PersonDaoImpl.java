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
		Session s = sessionFactory.openSession();
		List<Person> peopleList = s.createCriteria(Person.class).list();
		s.close();
		return peopleList;
	}

	@Override
	public Person getPersonById(int id) {
		Session s = sessionFactory.openSession();
		Person person = (Person) s.get(Person.class, id);
		s.close();
		return person;
	}

	@Override
	public void addPerson(Person p) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
=======
		Session s = sessionFactory.openSession();
		s.save(p);
		s.close();
	}

	@Override
	public int getIdByEmail(String email) {
		Session s = sessionFactory.openSession();
		Person person = (Person) s.get(Person.class, email);
		s.close();
		return person.getPersonID();
>>>>>>> ad9ce04... Refactor taking out the PersonInfo object from Java and SQL. Implementation of DAOs
	}

}
