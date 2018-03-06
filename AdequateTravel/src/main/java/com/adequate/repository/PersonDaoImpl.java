package com.adequate.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adequate.beans.Person;
import com.adequate.util.HibernateUtil;

@Repository("personRepository")
@Transactional
public class PersonDaoImpl implements PersonDao{

	@Autowired 
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPeople() {
		Session s = sessionFactory.openSession(); //TODO::This should work... but it doesnt
		//Session s = HibernateUtil.getSession();
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
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(p);
		
		tx.commit();
		s.close();
	}

}
