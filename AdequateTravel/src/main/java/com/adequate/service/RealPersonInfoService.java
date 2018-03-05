package com.adequate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adequate.beans.PersonInfo;
import com.adequate.repository.PersonInfoDao;

@Service("personInfoService")
public class RealPersonInfoService implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoRepository;
	
	@Override
	public PersonInfo getInfoById(Integer id) {
		return personInfoRepository.getInfoById(id);
	}

	@Override
	public void addPersonInfo(PersonInfo pi) {
		personInfoRepository.addPersonInfo(pi);		
	}

}
