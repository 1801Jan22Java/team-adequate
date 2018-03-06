package com.adequate.controller;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adequate.beans.Person;
import com.adequate.beans.PersonInfo;
import com.adequate.service.RealPersonService;

class CreatedPerson{
	private String email;
	private String fname;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String lname;
	private String password;
};

@CrossOrigin(origins = "http://localhost:4200")
@Controller("registerPersonController")
@RequestMapping("/register")
public class RegisterPersonController {
	
	public RegisterPersonController() {
			System.out.println("register start");
		}
	
	@Autowired 
	RealPersonService pService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> registerPerson(@RequestBody CreatedPerson createdPerson) {
		System.out.println("recieved: " + createdPerson.getEmail() + createdPerson.getFname() + createdPerson.getLname() + createdPerson.getPassword());
		PersonInfo personInfo = new PersonInfo(createdPerson.getFname(), createdPerson.getLname());
		//System.out.println((personInfo.getPersonID()));
		pService.addPerson(new Person(createdPerson.getEmail(), createdPerson.getPassword(), personInfo));
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	
}