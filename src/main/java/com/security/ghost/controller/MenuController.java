package com.security.ghost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class MenuController {
	
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
	public String makeStudyPage() {
		return "makeStudy"; 
	}
}
