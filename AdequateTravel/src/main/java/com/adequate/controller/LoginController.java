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
import com.adequate.service.PersonService;
import com.adequate.util.CurrentUser;

@CrossOrigin(origins = "http://localhost:4200")
@Controller("loginController")
@RequestMapping("/login")
public class LoginController {

	public LoginController() {
		System.out.println("start");
	}
	
	@Autowired 
	PersonService pService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("success", HttpStatus.OK); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Person person) {
		List<Person> people = pService.getAllPeople();
		for(Person p : people) {
			if(p.getEmail().equals(person.getEmail())) {
				if(p.getPassword().equals(person.getPassword()))
				{
					CurrentUser.login(person.getPersonID(), person.getEmail(), person.getPassword());
					return new ResponseEntity<>("success", HttpStatus.OK); 
				}
			}
		}
		
		return new ResponseEntity<>("failure", HttpStatus.OK);
		
	}
	
}