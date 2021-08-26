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
		
		// session 값으로 접근 권한 확인 후 접속 가능하게
		
		// 아닌 경우 
		// mav.setViewName("redirect:index"); 
		
		// 가능한 경우 
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
		// group_id 가지고 join 테이블 userid 싹다 받아오고
		// 권한 체크
		int user_id = Integer.parseInt(session.getAttribute("id").toString());

		List<GroupDTO> group_list = groupDAO.groupList(user_id);
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
		int user_id = Integer.parseInt(session.getAttribute("id").toString());
		
		// (26+26+10)^10
		String link = StringUtil.randomAlphanumericStringGenerator(10);
		GroupDTO groupDTO = new GroupDTO();
		groupDTO.setName(name);
		groupDTO.setLink(link);
		groupDTO.setDetail(detail);
		groupDTO.setManagerId(user_id);
		
		// TODO : link, name 중복체크
		
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