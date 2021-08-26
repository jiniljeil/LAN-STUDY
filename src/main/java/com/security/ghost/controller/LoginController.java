package com.security.ghost.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.Crypto;
import com.security.ghost.dao.UserDAO;
import com.security.ghost.dto.UserDTO;

@Controller 
public class LoginController {
	
	@Autowired
	UserDAO userDAO; 
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("user");
		session.removeAttribute("manager");
		String userid = request.getParameter("userID"); 
		String userpw = request.getParameter("userPW");
		if (userid != null && userpw != null) {
			if(userDAO.idDupCheck(userid)==0) {
				mav.setViewName("redirect:/error/loginError");
				return mav;
			}
			
			byte[] salt = userDAO.getSalt(userDAO.getID(userid)); 
			userpw = Crypto.encryptSHA256(userpw, salt);
			
			int trial = userDAO.getUserTrial(userid); 
			long failTime = userDAO.getTimeStamp(userid).getTime(); 
			long currTime = new Timestamp(System.currentTimeMillis()).getTime(); 
			
			// 로그인 시도 
			if (trial >= 5) {
				// 30초간 로그인 시도 불가능 
				if (currTime - failTime < 30000) {
					mav.setViewName("redirect:/error/loginTrialError");
					return mav; 
				}else {
					userDAO.incTrial(new UserDTO(0, userid)) ;
				}
			}
			
			UserDTO userDTO = userDAO.getUser(new UserDTO(userid, userpw));
			if(userDTO != null) {
				userDAO.incTrial(new UserDTO(0, userid)); 
				userDAO.setTimeStamp(new UserDTO(new Timestamp(System.currentTimeMillis()), userid, 1));
				userDAO.setTimeStamp(new UserDTO(new Timestamp(System.currentTimeMillis()), userid, 0));
				
				model.addAttribute("u", userDTO);
				session.setAttribute("id", userDTO.getId());
					
				mav.setViewName("redirect:/menu");
				return mav;
			// 로그인 실패 
			} else {
				userDAO.incTrial(new UserDTO(trial + 1, userid));
				// 틀린 경우 실패 시간 업데이트 
				userDAO.setTimeStamp(new UserDTO(new Timestamp(System.currentTimeMillis()), userid, 0));
			}
			// 로그인 실패 alert 띄우기 
			mav.setViewName("redirect:/error/loginError");
		}
		else mav.setViewName("redirect:/error/loginError");;
		return mav;
	}
	
//	@RequestMapping(value="/board")
//    public String getBoard(Model mdel) throws ServletException, IOException {		
//		List<UserDTO> userList = userDAO.getUserList();
//		model.addAttribute("list", userList );
//		return "homePage";
//    }
}