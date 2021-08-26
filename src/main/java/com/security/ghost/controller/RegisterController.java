package com.security.ghost.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.Crypto;
import com.security.ghost.SecurityUtil;
import com.security.ghost.StringUtil;
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
		
		// 필수 
		String userid = request.getParameter("userID"); 
		String userpw = request.getParameter("userPW"); 
		String nickname = request.getParameter("nickname");
		
		if(userid == null || userpw == null || nickname == null) {
			mav.setViewName("redirect:/error/registerIDPassNickError");
			return mav;
		}
		
		// 비 필수
		String firstPhoneNumber = request.getParameter("FirstPhoneNumber"); 
		String mediumPhoneNumber = request.getParameter("MediumPhoneNumber"); 
		String lastPhoneNumber = request.getParameter("LastPhoneNumber");
		
		//  폰 번호 검증 로직 
		if( !firstPhoneNumber.equals("010") && 
				!firstPhoneNumber.equals("011") && 
				!firstPhoneNumber.equals("016") &&
				!firstPhoneNumber.equals("017") &&
				!firstPhoneNumber.equals("019") &&
				!firstPhoneNumber.equals("")) {
			mav.setViewName("redirect:/error/registerPhoneEmailError");
			return mav;
		}
		if(mediumPhoneNumber.length() != 4 || lastPhoneNumber.length() != 4) {	
			mav.setViewName("redirect:/error/registerPhoneEmailError");
			return mav;
		}
		
		if( !StringUtil.isDigits(mediumPhoneNumber) || !StringUtil.isDigits(lastPhoneNumber)) {
			mav.setViewName("redirect:/error/registerPhoneEmailError");
			return mav;
		}
		String phoneNumber = firstPhoneNumber + mediumPhoneNumber + lastPhoneNumber ; 
		
		// email 검증 필요??
		String email = request.getParameter("email");
//		if(!email.contains("@")) {
//			mav.setViewName("redirect:/error/registerPhoneEmailError");
//			return mav;
//		}
		
		// 패스워드 설정 체크 (특수문자 포함 및 자리 수 확인) 
		if( userid.equals(userpw) || SecurityUtil.isValidPassword(userpw) == false) {
			mav.setViewName("redirect:/error/registerIDPassNickError");
			return mav;
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
		
		if(userDAO.joinUser(userDTO) != 1) {
			mav.setViewName("redirect:/error/registerIDPassNickError");
			return mav;
		}
		int id = userDAO.getID(userid);
		
		SaltDTO saltDTO = new SaltDTO(); 
		saltDTO.setUser_id(id); 
		saltDTO.setSalt(salt);

		if(userDAO.storeSalt(saltDTO) != 1) {
			mav.setViewName("redirect:/error/registerIDPassNickError");
			return mav;
		}
		
		// 회원 가입 완료
		mav.setViewName("redirect:/");
		return mav ;
	}
		
	
	@RequestMapping(value="/idDupChk", method=RequestMethod.POST)
	public String linkDupCheck(@RequestParam("id") String id) throws Exception {
		System.out.println(userDAO.idDupCheck(id));
		if(userDAO.idDupCheck(id)==0) return "success";
		else return "fail";
	}
}