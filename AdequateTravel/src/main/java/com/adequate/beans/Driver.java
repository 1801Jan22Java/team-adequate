package com.adequate.beans;

import org.hibernate.Session;

import com.adequate.repository.PersonDao;
import com.adequate.repository.PersonDaoImpl;
import com.adequate.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		PersonDao pd = new PersonDaoImpl();
		pd.addPerson(new Person("test","test","test","test"));
		
		s.close();
	}

}
