package com.security.ghost.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		String userid = request.getParameter("userID"); 
		String userpw = request.getParameter("userPW"); 
		 
		if (userid != null && userpw != null) {
			if(userDAO.idDupCheck(userid)==0) {
				mav.setViewName("redirect:/error/loginError");
				return mav;
			}
			
			byte[] salt = userDAO.getSalt(userDAO.getID(userid)); 
			userpw = Crypto.encryptSHA256(userpw, salt);

			UserDTO userDTO = userDAO.getUser(new UserDTO(userid, userpw));
			if(userDTO != null) {
				session.setAttribute("LOGIN_USER", userDTO); 
				model.addAttribute("u", userDTO);
				session.setAttribute("id", userDTO.getId());
				System.out.println("---->"+session.getAttribute("id"));
//				지금 이거 때문에 로그인안됨
//				String pToken = request.getParameter("param_csrf_token"); 
//				String sToken = (String)session.getAttribute("SESSION_CSRF_TOKEN"); 
//				if (pToken != null && pToken.equals(sToken)) {
//					mav.setViewName("redirect:/menu");
//					return mav;
//				} 
				mav.setViewName("redirect:/menu");
				return mav;
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