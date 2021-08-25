package com.security.ghost.controller;


import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value="/")
	public String main(HttpSession session) {
		session.setAttribute("SESSION_CSRF_TOKEN", UUID.randomUUID().toString());
		return "index";
	}
	
	@RequestMapping(value="/header")
	public String headercheck() {
		return "header";
	}
	
	@RequestMapping(value="/menu")
	public String menu() {
		return "menu";
	}
}
