package com.security.ghost.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.StringUtil;
import com.security.ghost.dao.GroupDAO;
import com.security.ghost.dto.GroupDTO;

@Controller 
public class MenuController {
	
	@Autowired
	GroupDAO groupDAO;
	
	@RequestMapping(value="/make_study") 
	public ModelAndView makeStudy() {
		ModelAndView mav = new ModelAndView(); 
		
		// session 값으로 접근 권한 확인 후 접속 가능하게
		
		// 아닌 경우 
		// mav.setViewName("redirect:index"); 
		
		// 가능한 경우 
		mav.setViewName("redirect:/makeStudy");
		return mav; 
	}
	
	@RequestMapping(value="/makeStudy")
	public String studyMainPage() {
		return "makeStudy"; 
	}
	
	@RequestMapping(value="/groupList")
	public String groupList() {
		return "groupList"; 
	}
	
	
	// study site 를 만드는 일을 함. 
	@RequestMapping(value="/makeGroupOk", method=RequestMethod.POST)
	public ModelAndView makeGroupOk(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		
		StringUtil rsg = new StringUtil();
		// (26+26+10)^10
		String link = rsg.randomAlphanumericStringGenerator(10);
		
		GroupDTO groupDTO = new GroupDTO();
		groupDTO.setName(name);
		groupDTO.setLink(link);
		groupDTO.setDetail(detail);
		
		// TODO : link, name 중복체크
		
		groupDAO.createGroup(groupDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/groupList");
		return mav; 
	}
}
