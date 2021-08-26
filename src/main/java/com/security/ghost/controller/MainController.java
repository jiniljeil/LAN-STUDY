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
	
	@RequestMapping(value="/board/{link}/userManage", method=RequestMethod.GET)
	public ModelAndView manageUser(@PathVariable("link") String link, Model model) {
		
		ModelAndView mav = new ModelAndView();
		
		int group_id = groupDAO.getGroupId(link);
		List<GroupUserDTO> user_list = userDAO.groupUserList(group_id);
		
		model.addAttribute("userList", user_list);
		model.addAttribute("userCnt", user_list.size());
		mav.setViewName("userManage");
		
		return mav;
	}
	
	@RequestMapping(value="/myPage")
	public  ModelAndView myPage(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int user_id = Integer.parseInt(session.getAttribute("id").toString());
		UserDTO user = userDAO.getUserInfo(user_id);
		
		model.addAttribute("user", user);
		mav.setViewName("myPage");
		
		return mav;
	}
}