package com.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String showHome()
	{
		return "startup";
	}
	
	@GetMapping("/leaders")
	public String showLeaders()
	{
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showSystems()
	{
		return "systems";
	}
	
}
