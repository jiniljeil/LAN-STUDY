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

import com.security.ghost.dao.UserDAO;
import com.security.ghost.dto.UserDTO;

@Controller 
public class LoginController {
	
	@Autowired
	UserDAO userDAO; 
	
	@RequestMapping(value="/login")
	public String login() {
		return "login"; 
	}
	
	public static String encryptSHA256(String pwd, String salt) {
		try{

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(salt.getBytes());
			byte[] hash = digest.digest(pwd.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			System.out.println(hexString.toString());
			//출력
			return hexString.toString();
			
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	

	
	@RequestMapping(value="/loginok", method=RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model) {
		String userid = request.getParameter("userID"); 
		String userpw = encryptSHA256(request.getParameter("userPW"), "1111");
		
		
		UserDTO checkDTO = new UserDTO();
		checkDTO.setUser_id(userid);
		checkDTO.setUser_pw(userpw);
		 
		
		UserDTO userDTO = userDAO.getUser(checkDTO);
		if(userDTO != null) {
			model.addAttribute("u", userDTO);
			return "redirect:board";
		} else {
			return "main";
		}
	}
	
	@RequestMapping(value="/board")
    public String getBoard(Model model) throws ServletException, IOException {		
		List<UserDTO> userList = userDAO.getUserList();
		model.addAttribute("list", userList );
		return "userboard";
    }
}
