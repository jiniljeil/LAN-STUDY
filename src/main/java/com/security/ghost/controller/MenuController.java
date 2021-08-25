package com.security.ghost.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.dto.UserDTO;

@Controller 
public class MenuController {
	
//	@RequestMapping(value="/menuPage") 
//	public String makeStudy(HttpServletRequest request, HttpSession session) {
//		String pToken = request.getParameter("param_csrf_token"); 
//		String sToken = (String) session.getAttribute("SESSION_CSRF_TOKEN");
//		UserDTO userDTO = (UserDTO) session.getAttribute("LOGIN_USER"); 
//		// session 값으로 접근 권한 확인 후 접속 가능하게
//		if (pToken != null && pToken.equals(sToken)) {
//			// TODO menu 로 바로 들어가버리는 경우 로그인 없이 들어간다. (취약점) 
//			return "menu"; 
//		}else {
////			// 에러처리 
//			return "redirect:index"; 
//		}
//	}
	
	@RequestMapping(value="/make_study")
	public String makeStudyPage(HttpSession session) {
		
		// TODO 접근 제한 확인 
		UserDTO userDTO = (UserDTO) session.getAttribute("LOGIN_USER"); 
		System.out.println(userDTO.getUser_id());
//		session.setAttribute("LOGIN_USER", userDTO);
		// session 값으로 접근 권한 확인 후 접속 가능하게
		if (userDTO != null ) {
//			mav.setViewName("redirect:/makeStudy");
			return "makeStudy"; 
		}else {
			// 에러처리 (에러 페이지로) 
//			mav.setViewName("redirect:/");
			return "/index"; 
		}
		
	}
}
