package com.adequate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.adequate.util.CurrentUser;

@Controller("logoutController")
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView logout(){
		CurrentUser.logout(); // null-ifies all info on user 
		return new ModelAndView("redirect:http://localhost:8080/AdequateTravel/login");
	}
}
