package com.security.ghost.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.SecurityUtil;
import com.security.ghost.dao.AdDAO;
import com.security.ghost.dao.GroupDAO;
import com.security.ghost.dao.UserDAO;
import com.security.ghost.dto.AdDTO;
import com.security.ghost.dto.BoardDTO;
import com.security.ghost.dto.GroupDTO;
import com.security.ghost.dto.UserDTO;

@RestController
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
		String g_id = request.getParameter("g_id"); 
		String title = request.getParameter("title"); 
		String content = request.getParameter("content"); 
		
		int group_id = Integer.parseInt(g_id);
		
		System.out.println(group_id);
		
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
				// TODO group_id setting 
				int user_id = Integer.parseInt(session.getAttribute("id").toString());
				adDTO.setUser_id(user_id);
				adDTO.setGroup_id(group_id);
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
	public ModelAndView AdStudy(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView(); 
		
		List<AdDTO> adList = adDAO.getAdList();

		// What if no group?
		
		model.addAttribute("AdList", adList);
		mav.setViewName("AdStudy");
		
		return mav;
	}
	
	@RequestMapping(value="/joinGroup") 
	public ModelAndView joinGroup(HttpServletRequest request, HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView(); 
		int user_id = Integer.parseInt(session.getAttribute("id").toString());
		int group_id = Integer.parseInt(request.getParameter("group_id"));
		
		
		
		
		
		HashMap<String ,Integer > joinInfo = new HashMap<String, Integer>();
		joinInfo.put("user_id", user_id);
		joinInfo.put("group_id", group_id);
		joinInfo.put("auth", 2);
		
		// Already Joined!
		if(groupDAO.checkJoinExist(joinInfo) != 0) {
			mav.setViewName("redirect:/error/joinError");
		} else {
			if(groupDAO.createJoin(joinInfo) != 1) {
				mav.setViewName("redirect:/error/sqlError");
			}else {
				mav.setViewName("redirect:/groupList");
			}
		}
		return mav;
	}
	
	@RequestMapping(value="/ajaxGetMyGroups", method=RequestMethod.POST) 
	public List<GroupDTO> ajaxGetMyGroups(HttpSession session, Model model) {
		int user_id = Integer.parseInt(session.getAttribute("id").toString());
		
		// ok to be null
		List<GroupDTO> groupList = groupDAO.getMyGroup(user_id);
		model.addAttribute("groupList", groupList);
	    
		return groupList;
	}
	
	@RequestMapping(value="/ajaxGetGroup",method=RequestMethod.POST) 
	public GroupDTO ajaxGetGroup(HttpServletRequest request, Model model) {
	
		String group_id = request.getParameter("group_id");
		int g_id = Integer.parseInt(group_id);
		GroupDTO groupDTO = new GroupDTO();
		groupDTO = groupDAO.getGroupById(g_id);
		
		model.addAttribute("group", groupDTO);
		
		return groupDTO;
	}
}