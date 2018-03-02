package com.adequate.beans;

import org.hibernate.Session;

import com.adequate.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		
		s.close();

	}

}
