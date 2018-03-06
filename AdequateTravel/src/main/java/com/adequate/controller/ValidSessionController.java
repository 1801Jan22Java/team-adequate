package com.adequate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adequate.util.CurrentUser;

@Controller("validSessionController")
@RequestMapping("/validate")
public class ValidSessionController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<String> validateSession(){
		if(CurrentUser.getValidSession())
			return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.ACCEPTED);
		
		return new ResponseEntity<>("{\"status\":\"failure\"}", HttpStatus.OK);
	}

}
