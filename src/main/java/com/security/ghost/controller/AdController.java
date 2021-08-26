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
		session.removeAttribute("user");
		session.removeAttribute("manager");
		String title = request.getParameter("title"); 
		String content = request.getParameter("content"); 
		
		int group_id = -1;
		if (g_id != null) {
			group_id = Integer.parseInt(g_id);
			
			if (title != null && content != null) {
				// XSS BLOCK 
				title = SecurityUtil.HTML_Filter(title); 
				content = SecurityUtil.HTML_Filter(content); 

				AdDTO adDTO = new AdDTO(); 
				
				String id = session.getAttribute("id").toString(); 
				int user_id = -1 ; 
				if (id != null) {
					user_id = Integer.parseInt(id);
					adDTO.setUser_id(user_id);
					adDTO.setGroup_id(group_id);
					adDTO.setTitle(title); 
					adDTO.setContent(content);
				}
				
				if(adDAO.uploadAd(adDTO) != 1) {
					mav.setViewName("redirect:/error/sqlError");
				} else{
					mav.setViewName("redirect:/homePage");
				}	
			}else {
				mav.setViewName("redirect:/error/uploadError");
			}
		}else {
			mav.setViewName("redirect:/error/uploadError");
		}
		return mav;
	}
	
	@RequestMapping(value="/homePage") 
	public ModelAndView AdStudy(HttpServletRequest request, Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String keyword = request.getParameter("keyword");
		String qkeyword;
		if(keyword == null)
			qkeyword = "%%";
		else 
			qkeyword = "%" + keyword +"%";
		session.removeAttribute("user");
		session.removeAttribute("manager");
		
		List<AdDTO> adList = adDAO.searchAd(qkeyword);

		// What if no group?
		
		model.addAttribute("AdList", adList);
		model.addAttribute("keyword", keyword);
		mav.setViewName("AdStudy");
		
		return mav;
	}
	
	@RequestMapping(value="/joinGroup") 
	public ModelAndView joinGroup(HttpServletRequest request, HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView(); 
		String id = session.getAttribute("id").toString(); 
		
		int user_id = -1; 
		if (id != null) {
			user_id = Integer.parseInt(id);
		}
		
		String gid = request.getParameter("group_id"); 
		int group_id = -1; 
		if (gid != null) {
			group_id = Integer.parseInt(gid);
		}
		
		HashMap<String ,Integer > joinInfo = new HashMap<String, Integer>();
		joinInfo.put("user_id", user_id);
		joinInfo.put("group_id", group_id);
		joinInfo.put("auth", 2);
		
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
		String id = session.getAttribute("id").toString(); 
		
		int user_id = -1;
		if ( id != null) {
			user_id = Integer.parseInt(id);
		}
		
		List<GroupDTO> groupList = null ; 
		
		if ( user_id != -1) { 
			groupList = groupDAO.getMyGroup(user_id);
			model.addAttribute("groupList", groupList);
		}
		
		return groupList;
	}
	
	@RequestMapping(value="/ajaxGetGroup",method=RequestMethod.POST) 
	public GroupDTO ajaxGetGroup(HttpServletRequest request, Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView(); 
		session.removeAttribute("user");
		session.removeAttribute("manager");
		String group_id = request.getParameter("group_id");
		
		int g_id = -1; 
		if ( group_id != null) {
			g_id = Integer.parseInt(group_id);
		}
		
		GroupDTO groupDTO = new GroupDTO();
		if (g_id != -1) {
			groupDTO = groupDAO.getGroupById(g_id);
			model.addAttribute("group", groupDTO);
		}
		
		return groupDTO;
	}
}