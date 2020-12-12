package com.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "plain-login";
	}
	
	//Adding request mapping for ACCESS DENIED
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}

}

