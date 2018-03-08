package com.adequate.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(p);
		
		tx.commit();
		s.close();
	}
	
	@Override
	public void updatePerson(Person p) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.merge(p);
		
		tx.commit();
		s.close();
	}

	@Override
	public int getIdByEmail(String email) {
		Session s = sessionFactory.openSession();
		Criteria c = s.createCriteria(Person.class)
				.add(Restrictions.eq("email", email));
		Person person = (Person) c.uniqueResult();
		s.close();
		return person == null ? -1 : person.getPersonID();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getLikeSearch(String query) {
		List<Person> listPeople = new ArrayList<Person>();
		Session s = sessionFactory.openSession();
		List<Person> fnameList = s.createCriteria(Person.class).add(Restrictions.like("firstname", query+"%").ignoreCase() ).list();
		List<Person> lnameList = s.createCriteria(Person.class).add(Restrictions.like("lastname", query+"%").ignoreCase() ).list();
		List<Person> emailList = s.createCriteria(Person.class).add(Restrictions.like("email", query+"%").ignoreCase() ).list();
		
		listPeople.addAll(fnameList);
		listPeople.addAll(lnameList);
		listPeople.addAll(emailList);
		HashMap<Integer,String> contains = new HashMap<Integer,String>();
		List<Person> returnPeople = new ArrayList<Person>();
		for(Person p : listPeople) {
			if(!contains.containsKey(p.getPersonID())) {
				contains.put(p.getPersonID(), p.getFirstname());
				returnPeople.add(p);
			}
		}
		
		
		return returnPeople;
	}

}
