package com.security.ghost.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value="/")
	public String main() {
		return "index";
	}
	
	@RequestMapping(value="/header")
	public String headercheck() {
		return "header";
	}
}
