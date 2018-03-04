package com.adequate.repository;

import com.adequate.beans.PersonInfo;

public interface PersonInfoDao {

	public PersonInfo getInfoById(Integer id);
	
	public void addPersonInfo(PersonInfo pi);
	
}
