package com.adequate.controller;

import java.sql.Blob;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adequate.beans.Person;
import com.adequate.service.RealPersonService;
import com.adequate.util.CurrentUser;

class UpdatePerson{
	// Object received from Client, representing info client has access to
	private String email;
	private String fname;
	private String lname;
	private String desc;
	private Blob img;
	
	public Blob getImg() {
		return img;
	}
	public void setImg(Blob img) {
		this.img = img;
	}
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
};


@CrossOrigin(origins = "http://localhost:4200")
@Controller("profileController")
@RequestMapping("/account")
public class ProfileController {

	// go-between for people in the database and Controller
	@Autowired 
	private RealPersonService personService;
	
	//response to all HTTP GETs, create a 
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<String> getProfile(){
		System.out.println("User Get");
		System.out.println("id: " + CurrentUser.getUserID());
		Person user = personService.getPersonById(CurrentUser.getUserID());
		System.out.println(user.getEmail());
		return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> updateProfile(@RequestBody UpdatePerson person){
				
		// use the email from RequestBody to get the desired person object from DB
		Person comparePerson = personService.getPersonById(personService.getIdByEmail(person.getEmail()));
		
		if(comparePerson == null) {
			return new ResponseEntity<>("{\"status\":\"does_not_exist\"}", HttpStatus.OK);
		} else {
			comparePerson.setFirstname(person.getFname());
			comparePerson.setLastname(person.getLname());
			comparePerson.setAbout(person.getDesc());
			try {
				byte [] image = person.getImg().getBytes(1l, (int) person.getImg().length());
				comparePerson.setImage(image);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.ACCEPTED);
	}
	
}
