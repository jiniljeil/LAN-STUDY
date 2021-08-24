package com.security.ghost.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.ghost.Crypto;
import com.security.ghost.dao.UserDAO;
import com.security.ghost.dto.UserDTO;

@Controller 
public class LoginController {
	
	@Autowired
	UserDAO userDAO; 
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model) {
		String userid = request.getParameter("userID"); 
		String userpw = request.getParameter("userPW"); 
		
		if (userid != null && userpw != null) {
			byte[] salt = userDAO.getSalt(userid); 
			userpw = Crypto.encryptSHA256(userpw, salt);

			UserDTO userDTO = userDAO.getUser(new UserDTO(userid, userpw));
			if(userDTO != null) {
				model.addAttribute("u", userDTO);
				return "redirect:board";
			} 
		}
		return "index"; 
	}
	
	@RequestMapping(value="/board")
    public String getBoard(Model model) throws ServletException, IOException {		
		List<UserDTO> userList = userDAO.getUserList();
		model.addAttribute("list", userList );
		return "homePage";
    }
}
