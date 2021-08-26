package com.security.ghost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.SecurityUtil;
import com.security.ghost.dao.AdDAO;
import com.security.ghost.dto.AdDTO;
import com.security.ghost.dto.BoardDTO;
import com.security.ghost.dto.UserDTO;

@Controller
public class AdController {
	
	@Autowired
	AdDAO adDAO ;
	
	@RequestMapping(value="/upload", method=RequestMethod.POST) 
	public ModelAndView AdOk(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView(); 
		String title = request.getParameter("title"); 
		String content = request.getParameter("content"); 
		
		if (title != null && content != null) {
			// TODO Session 유저 권한 체크 및 유저 ID 포함하여 디비에 저장 
			UserDTO userDTO = (UserDTO)session.getAttribute("LOGIN_USER"); 

			if (userDTO != null) {
				// XSS BLOCK 
				// encodeforhtml 
				title = SecurityUtil.HTML_Filter(title); 
				content = SecurityUtil.HTML_Filter(content); 

				AdDTO adDTO = new AdDTO(); 
				// TODO user_id group_id setting 
				adDTO.setUser_id(userDTO.getId());
				adDTO.setGroup_id(1);
				adDTO.setTitle(title); 
				adDTO.setContent(content);
				
				adDAO.uploadAd(adDTO);
				mav.setViewName("redirect:/homePage");
			}
		}else {
			// Q. 업로드 실패 혹은 제목 및 내용 입력 요구 
			// 어디로 보낼 것 인가? 
			mav.setViewName("redirect:/");
		}
		return mav;
	}
	
	@RequestMapping(value="/homePage", method=RequestMethod.GET) 
	public String AdStudy(HttpServletRequest request, Model model) {
	     
		// session으로 사용자의 정보를 가지고 가지고 있지 않는 group 들을 뿌려준다.
		List<BoardDTO> adList = adDAO.getAdList();
		model.addAttribute("AdList", adList);
	      
		return "AdStudy";
	}
}