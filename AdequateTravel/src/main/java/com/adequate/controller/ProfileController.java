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
import com.adequate.beans.Person;
import com.adequate.service.RealPersonService;
import com.adequate.service.RealPersonService;
import com.adequate.util.CurrentUser;

@CrossOrigin(origins = "http://localhost:4200")
@Controller("profileController")
@RequestMapping("/account")
public class ProfileController {

	
	@Autowired 
	private RealPersonService personService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Person> getProfile(){
		return new ResponseEntity<>(personService.getPersonById(CurrentUser.getUserID()), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> updateProfile(@RequestBody Person clientInfo){
		Person oldPerson = personService.getInfoById(CurrentUser.getUserID());
		Person newPerson new Person();
		// assigning oldPerson to newPerson, to be overwritten if it differs from clientInfo
		
		if(!clientInfo.getFirstname().equals(newPerson.getFirstname())) {
			newPerson.setFirstname(clientInfo.getFirstname());
		}
		if(!clientInfo.getLastname().equals(newPerson.getLastname())) {
			newPerson.setLastname(clientInfo.getLastname());
		}
		if(!clientInfo.getAbout().equals(newPerson.getAbout())){
			newPerson.setAbout(clientInfo.getAbout());
		}
		if(!clientInfo.getImage().equals(newPerson.getImage())) {
			newPerson.setImage(clientInfo.getImage());
		}
		personService.addPerson(newPerson);
		
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
}
