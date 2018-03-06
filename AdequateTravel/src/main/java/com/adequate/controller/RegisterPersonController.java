package com.adequate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adequate.beans.Person;
import com.adequate.beans.PersonInfo;
import com.adequate.service.RealPersonService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller("registerPersonController")
@RequestMapping("/register")
public class RegisterPersonController {
	
	@Autowired 
	RealPersonService pService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> registerPerson
	(@RequestParam("email") String email, @RequestParam("password") String password,
	 @RequestParam("fname") String firstName, @RequestParam("lname") String lastName){

		pService.addPerson(new Person(email, password, firstName, lastName));
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	
}
