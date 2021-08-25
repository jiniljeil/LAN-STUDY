package com.security.ghost.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.SecurityUtil;
import com.security.ghost.dto.BoardDTO;

@Controller 
public class TestController {
	
	
	@RequestMapping(value="/group") 
	public String groupPage() {
		// 권한 확인 
		return "group"; 
	}
	
//	@RequestMapping(value="/boardList", method=RequestMethod.POST)
//	public ViewAndModel boardList(HttpServletRequest request, Model moel) {
//		ModelAndView mav = new ModelAndView(); 
//		
//		// TODO: 세션 값으로 id 확인 및 접근 권한 체크 우선
//		
//		String content = request.getParameter("content");
//		if (content != null) {
//			content = SecurityUtil.HTML_Filter(content); 
//			
//			BoardDTO boardDTO = new BoardDTO(); 
//			
//		}else {
//			
//		}
//	}
}
