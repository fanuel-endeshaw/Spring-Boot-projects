package com.oath.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Maincontroller {

	
	@RequestMapping("/")
	public String home() {
		return "hallo";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "welcome";
	}
}
