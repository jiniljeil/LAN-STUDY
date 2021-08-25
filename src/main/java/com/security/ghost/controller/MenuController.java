package com.security.ghost.controller;

import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;

=======

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 21e31e3feab344b5cb9ec89c3e216e7f9cd235bc
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
import com.security.ghost.dto.UserDTO;
=======
import com.security.ghost.StringUtil;
import com.security.ghost.dao.GroupDAO;
import com.security.ghost.dto.GroupDTO;
>>>>>>> 21e31e3feab344b5cb9ec89c3e216e7f9cd235bc

@Controller 
public class MenuController {
	
<<<<<<< HEAD
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
=======
	@Autowired
	GroupDAO groupDAO;
	
	@RequestMapping(value="/make_study") 
	public ModelAndView makeStudy() {
		ModelAndView mav = new ModelAndView(); 
>>>>>>> 21e31e3feab344b5cb9ec89c3e216e7f9cd235bc
		
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
		
<<<<<<< HEAD
=======
		// 아닌 경우 
		// mav.setViewName("redirect:index"); 
		
		// 가능한 경우 
		mav.setViewName("redirect:/makeStudy");
		return mav; 
	}
	
	@RequestMapping(value="/makeStudy")
	public String studyMainPage() {
		return "makeStudy"; 
>>>>>>> 21e31e3feab344b5cb9ec89c3e216e7f9cd235bc
	}
	
	
	// study site 를 만드는 일을 함. 
	@RequestMapping(value="/makeGroupOk")
	public ModelAndView makeGroupOk(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		
		StringUtil rsg = new StringUtil();
		// (26+26+10)^10
		String link = rsg.randomAlphanumericStringGenerator(10);
		
		GroupDTO groupDTO = new GroupDTO();
		groupDTO.setName(name);
		groupDTO.setLink(link);
		
		groupDAO.createGroup(groupDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/make_study");
		return mav; 
	}
}
