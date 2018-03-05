package com.adequate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adequate.util.CurrentUser;

@Controller("logoutController")
@RequestMapping("/logout")
public class LogoutController {

	
	public ModelAndView logout(){
		CurrentUser.logout(); // null-ifies all info on user 
		return new ModelAndView("redirect:/login");
	}
}
