package com.adequate.controller;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adequate.util.CurrentUser;

@Controller("logoutController")
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> logout(){
		System.out.println("User logging out...");
		CurrentUser.logout(); // null-ifies all info on user 
		return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.ACCEPTED); 
	}
}
