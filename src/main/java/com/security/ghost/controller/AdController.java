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
import com.security.ghost.dao.GroupDAO;
import com.security.ghost.dao.UserDAO;
import com.security.ghost.dto.AdDTO;
import com.security.ghost.dto.BoardDTO;
import com.security.ghost.dto.GroupDTO;
import com.security.ghost.dto.UserDTO;

@Controller
public class AdController {
	
	@Autowired
	AdDAO adDAO ;
	
	@Autowired
	UserDAO userDAO ;
	
	@Autowired
	GroupDAO groupDAO;
	
	@RequestMapping(value="/upload", method=RequestMethod.POST) 
	public ModelAndView AdOk(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView(); 
		String title = request.getParameter("title"); 
		String content = request.getParameter("content"); 
		
		if (title != null && content != null) {
			// TODO Session 유저 권한 체크 및 유저 ID 포함하여 디비에 저장 
			
			// UserDTO userDTO = (UserDTO)session.getAttribute("LOGIN_USER"); 
			UserDTO userDTO = userDAO.getUserById("qpalzmm22");
			
			if (userDTO != null) {
				// XSS BLOCK 
				// encodeforhtml 
				title = SecurityUtil.HTML_Filter(title); 
				content = SecurityUtil.HTML_Filter(content); 

				AdDTO adDTO = new AdDTO(); 
				// TODO user_id group_id setting 
				adDTO.setUser_id(userDTO.getId());
				adDTO.setGroup_id(3);
				adDTO.setTitle(title); 
				adDTO.setContent(content);
				
				if(adDAO.uploadAd(adDTO) != 1) {
					mav.setViewName("redirect:/error/sqlError");
				} else{
					mav.setViewName("redirect:/homePage");
				}
			} else { // userDTO == null
				// 에러처리
			}
		}else {
			// Q. 업로드 실패 혹은 제목 및 내용 입력 요구 
			// 어디로 보낼 것 인가? 
			mav.setViewName("redirect:/error/uploadError");
		}
		return mav;
	}
	
	@RequestMapping(value="/homePage") 
	public String AdStudy(HttpServletRequest request, Model model) {
	     
		// session으로 사용자의 정보를 가지고 가지고 있지 않는 group 들을 뿌려준다.
		List<BoardDTO> adList = adDAO.getAdList();
		model.addAttribute("AdList", adList);
	      
		return "AdStudy";
	}
	
	@RequestMapping(value="/ajaxGetGroup",method=RequestMethod.POST) 
	public void ajaxGetGroup(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView(); 
	
		String group_id = request.getParameter("group_id");
		int g_id = Integer.parseInt(group_id);
		
		GroupDTO groupDTO = new GroupDTO();
		groupDTO = groupDAO.getGroupById(g_id);
		
		model.addAttribute("group", groupDTO);
		
		return ;
	}
}