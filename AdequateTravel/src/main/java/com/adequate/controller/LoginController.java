package com.adequate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adequate.beans.Person;
import com.adequate.service.RealPersonService;
import com.adequate.util.CurrentUser;

@CrossOrigin(origins = "http://localhost:4200")
@Controller("loginController")
@RequestMapping("/login")
public class LoginController {
	
	@Autowired 
	RealPersonService pService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Person person) {

		List<Person> people = pService.getAllPeople();
		if(people != null) {
			for(Person p : people) {
				if(p.getEmail().equals(person.getEmail())) {
					if(p.getPassword().equals(person.getPassword()))
					{
						
						CurrentUser.login(p.getPersonID(), p.getEmail(), p.getPassword());
					
						System.out.println("Logged in! " + p.getPersonID());
						return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.ACCEPTED);
					}
				}
			}
		}
		return new ResponseEntity<>("{\"status\":\"failed\"}", HttpStatus.ACCEPTED);
		
	}
	
}