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
public class JoinController {
	
	@Autowired
	UserDAO userDAO; 
	
	@RequestMapping(value="/join")
	public String join() {
		return "join"; 
	}
	
	@RequestMapping(value="/joinOK", method=RequestMethod.POST)
	public String joinOK(HttpServletRequest request, Model model) {
		
		String userid = request.getParameter("userID"); 
		String userpw = request.getParameter("userPW"); 
		// 패스워드 암호화 
		// 패스워드 설정 체크 (특수문자 포함 및 자리 수 확인) 
		String firstPhoneNumber = request.getParameter("FirstPhoneNumber"); 
		String mediumPhoneNumber = request.getParameter("MediumPhoneNumber"); 
		String lastPhoneNumber = request.getParameter("LastPhoneNumber"); 
		
		//  폰 번호 검증 로직 
		String phoneNumber = firstPhoneNumber + mediumPhoneNumber + lastPhoneNumber ; 
		
		String email = request.getParameter("email"); 
		String nickname = request.getParameter("nickname"); 
		String job = request.getParameter("job"); 
		
		UserDTO userDTO = new UserDTO(); 
		
		userDTO.setUser_id(userid); 
		userDTO.setUser_pw(userpw); 
		userDTO.setPhone_number(phoneNumber); 
		userDTO.setEmail(email);
		
		userDAO.joinUser(userDTO);
		
		return "index" ; 
	}
}
