package com.security.ghost.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.Crypto;
import com.security.ghost.dao.UserDAO;
import com.security.ghost.dto.SaltDTO;
import com.security.ghost.dto.UserDTO;

@RestController 
public class RegisterController {
	
	@Autowired
	UserDAO userDAO; 
	
	@RequestMapping(value="/join")
	public ModelAndView join() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("join");
		return mav; 
	}
	
	@RequestMapping(value="/joinOK", method=RequestMethod.POST)
	public ModelAndView joinOK(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView();
		
		String userid = request.getParameter("userID"); 
		String userpw = request.getParameter("userPW"); 
		
		// 패스워드 설정 체크 (특수문자 포함 및 자리 수 확인) 
		if (userpw != null) {
			
		}
		
		String firstPhoneNumber = request.getParameter("FirstPhoneNumber"); 
		String mediumPhoneNumber = request.getParameter("MediumPhoneNumber"); 
		String lastPhoneNumber = request.getParameter("LastPhoneNumber"); 
		
		//  폰 번호 검증 로직 
		String phoneNumber = firstPhoneNumber + mediumPhoneNumber + lastPhoneNumber ; 
		
		String email = request.getParameter("email"); 
		String nickname = request.getParameter("nickname"); 
		String job = request.getParameter("job");
		
		if (email != null && nickname != null && job != null) {
			
		}
		
		// 패스워드 암호화 
		byte[] salt = Crypto.generateSalt();
		userpw = Crypto.encryptSHA256(userpw, salt); 
		
		UserDTO userDTO = new UserDTO(); 
		
		userDTO.setName(nickname);
		userDTO.setUser_id(userid); 
		userDTO.setUser_pw(userpw); 
		userDTO.setPhone(phoneNumber); 
		userDTO.setEmail(email);
		
		userDAO.joinUser(userDTO);
		int id = userDAO.getID(userid);
		
		SaltDTO saltDTO = new SaltDTO(); 
		saltDTO.setUser_id(id); 
		saltDTO.setSalt(salt);

		userDAO.storeSalt(saltDTO);
		// 회원 가입 완료 또는 실패 작업
		mav.setViewName("redirect:/index");
		return mav ; 
	}
	
	@RequestMapping(value="/idDupChk", method=RequestMethod.POST)
	public String linkDupCheck(@RequestParam("id") String id) throws Exception {
		System.out.println(userDAO.idDupCheck(id));
		if(userDAO.idDupCheck(id)==0) return "success";
		else return "fail";
	}
}
