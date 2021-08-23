package com.security.ghost.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.ghost.dao.UserDAO;
import com.security.ghost.dto.UserDTO;

@Controller 
public class LoginController {
	
	@Autowired
	UserDAO userDAO; 
	
//	@RequestMapping(value="/login")
//	public String login() {
//		return "loginOK"; 
//	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model) {
		String userid = request.getParameter("userID"); 
		String userpw = request.getParameter("userPW");
		
		UserDTO userDTO = userDAO.getUser(userid); 
		model.addAttribute("u", userDTO); 
		return "user"; 
	}
}
