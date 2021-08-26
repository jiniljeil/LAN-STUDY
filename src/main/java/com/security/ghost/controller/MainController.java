package com.security.ghost.controller;


import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.dao.GroupDAO;
import com.security.ghost.dao.UserDAO;
import com.security.ghost.dto.GroupDTO;
import com.security.ghost.dto.GroupUserDTO;
import com.security.ghost.dto.UserDTO;

@Controller
public class MainController {
	
	@Autowired 
	UserDAO userDAO; 
	
	@Autowired
	GroupDAO groupDAO;
	
	@RequestMapping(value="/")
	public String main(HttpSession session) {
		if(session!=null)
			session.invalidate();
		return "index";
	}

	@RequestMapping(value="/logout")
	public String logOut(HttpSession session) {
		if(session!=null)
			session.invalidate();
		return "logout";
	}
	
	@RequestMapping(value="/menu")
	public String menu(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("manager");
		return "menu";
	}
	
	@RequestMapping(value="/deleteUser")
	public ModelAndView deleteUser(HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView();
		String id = session.getAttribute("id").toString() ;
		int user_id = -1 ; 
		
		if (id != null) {
			user_id = Integer.parseInt(id);
		}
		
		String name = userDAO.getUserName(user_id);
		model.addAttribute("name", name);
		mav.setViewName("deleteUser");
		return mav;
	}
	
	@RequestMapping(value="/join/confirm")
	public ModelAndView accessError(HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joinConfirm");
		return mav;
	}
	
	
	@RequestMapping(value="/myPage")
	public  ModelAndView myPage(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("user");
		session.removeAttribute("manager");
		
		String id = session.getAttribute("id").toString() ;
		int user_id = -1; 
		if(id != null) {
			user_id = Integer.parseInt(id);
		}

		UserDTO user = userDAO.getUserInfo(user_id);
		
		model.addAttribute("user", user);
		mav.setViewName("myPage");
		
		return mav;
	}
}