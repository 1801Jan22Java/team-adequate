package com.adequate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adequate.beans.Person;
import com.adequate.beans.PersonInfo;
import com.adequate.service.RealPersonInfoService;
import com.adequate.service.RealPersonService;
import com.adequate.util.CurrentUser;

@CrossOrigin(origins = "http://localhost:4200")
@Controller("profileController")
@RequestMapping("/account")
public class ProfileController {

	
	@Autowired 
	private RealPersonService personService;
	
	@Autowired 
	private RealPersonInfoService personInfoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Person> getProfile(){
		return new ResponseEntity<>(personService.getPersonById(CurrentUser.getUserID()), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> updateProfile(@RequestBody Person person){
		Person oldPerson = personService.getPersonById(CurrentUser.getUserID());
		PersonInfo oldPersonInfo = personInfoService.getInfoById(CurrentUser.getUserID());
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
}
