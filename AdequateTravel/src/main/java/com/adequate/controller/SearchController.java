package com.adequate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin(origins = "http://localhost:4200")
@Controller("searchController")
@RequestMapping("/search")
public class SearchController {
	
	private final String geoCodingPrefix = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	private final String geoCodingSuffix = "&key=AIzaSyA-cqeJ3xy8IXWiIffplTwOUqZODVvMBps";
	
}
