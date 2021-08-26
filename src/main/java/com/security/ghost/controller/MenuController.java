package com.security.ghost.controller;

import java.util.HashMap;
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
import com.security.ghost.StringUtil;
import com.security.ghost.dao.GroupDAO;
import com.security.ghost.dto.GroupDTO;

@Controller 
public class MenuController {
	
	@Autowired
	GroupDAO groupDAO;
	
	@RequestMapping(value="/make_study") 
	public ModelAndView makeStudy() {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("redirect:/makeStudy");
		return mav; 
	}
	
	@RequestMapping(value="/makeStudy")
	public String studyMainPage() {
		return "makeStudy"; 
	}
	
	@RequestMapping(value="/groupList")
	public ModelAndView groupList(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String id = session.getAttribute("id").toString(); 
		int user_id = -1; 
		if (id != null) {
			user_id = Integer.parseInt(id);
		}

		List<GroupDTO> group_list = groupDAO.groupList(user_id);
		
		model.addAttribute("user_id", user_id);
		model.addAttribute("groupList", group_list);
		model.addAttribute("groupCnt", group_list.size());
		
		mav.setViewName("groupList");
		return mav; 
	}
	
	@RequestMapping(value="/AdStudy")
	public String adStudy() {
		return "AdStudy";
	}
	
	@RequestMapping(value="/join_study")
	public ModelAndView join_study() {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("redirect:/AdStudy");
		return mav;
	}
	
	
	// study site 를 만드는 일을 함. 
	@RequestMapping(value="/makeGroupOk", method=RequestMethod.POST)
	public ModelAndView makeGroupOk(HttpServletRequest request, Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		int user_id = -1; 
		if( name != null && detail != null) {
			name = SecurityUtil.HTML_Filter(name); 
			detail = SecurityUtil.HTML_Filter(detail); 
			
			String id = session.getAttribute("id").toString(); 
			user_id = Integer.parseInt(id);
		}else {
			mav.setViewName("redirect:/error/uploadError");
			return mav; 
		}
		
		String link = StringUtil.randomAlphanumericStringGenerator(10);
		GroupDTO groupDTO = new GroupDTO();
		
		groupDTO.setName(name);
		groupDTO.setLink(link);
		groupDTO.setDetail(detail);
		groupDTO.setManagerId(user_id);
		
		if(groupDAO.createGroup(groupDTO) != 1) {
			mav.setViewName("redirect:/error/sqlError");
			return mav;
		};
		
		
		HashMap<String ,Integer > joinInfo = new HashMap<String, Integer>();
		int group_id = groupDAO.getGroupId(link);
		joinInfo.put("user_id", user_id);
		joinInfo.put("group_id", group_id);
		joinInfo.put("auth", 0);
		if(groupDAO.createJoin(joinInfo) != 1) {
			mav.setViewName("redirect:/error/sqlError");
			return mav;
		}
		
		mav.setViewName("redirect:/groupList");
		return mav; 
	}
}