package com.adequate.repository;

import org.junit.Test; 

import com.adequate.beans.Person;

import static org.junit.Assert.*;

public class PersonDaoTest {

	@Test
	public void getAllPeopleTest() {
		PersonDaoImpl pdi = new PersonDaoImpl();
		assertNotNull(pdi.getAllPeople());
	}
	
	@Test
	public void getPersonByIdTest() {
		PersonDaoImpl pdi = new PersonDaoImpl();
		Person p = pdi.getPersonById(3); // Test person, name / password is test
		assertNotNull(p);
	}
	
	@Test
	public void getIdByEmailTest() {
		PersonDaoImpl pdi = new PersonDaoImpl();
		assertNotSame(0, pdi.getIdByEmail("test"));
	}
	
	@Test
	public void addPersonTest() {
		Person p = new Person("fake", "fake", "fake", "fake");
		PersonDaoImpl pdi = new PersonDaoImpl();
		pdi.addPerson(p);
		assertNotNull(pdi.getPersonById(pdi.getIdByEmail("fake")));
	}
	
	@Test
	public void updateFirstNameTest() {
		Person p = new Person("notReal", "pass", "john", "doe");
		PersonDaoImpl pdi = new PersonDaoImpl();
		int fakeID = pdi.getIdByEmail("fake");
		pdi.addPerson(p);
		p.setFirstname("jane");
		pdi.updatePerson(p);
		assertEquals("Update Person should update first name", pdi.getPersonById(fakeID).getFirstname(), "jane");
	}
	
	@Test
	public void updateLastNameTest() {
		Person p = new Person("notReal", "pass", "john", "doe");
		PersonDaoImpl pdi = new PersonDaoImpl();
		int fakeID = pdi.getIdByEmail("fake");
		pdi.addPerson(p);
		p.setLastname("dick");
		pdi.updatePerson(p);
		assertEquals("Update Person should update last name", pdi.getPersonById(fakeID).getLastname(), "dick");
	}
	
}
