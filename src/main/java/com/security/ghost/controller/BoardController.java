package com.security.ghost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.SecurityUtil;
import com.security.ghost.dao.BoardDAO;
import com.security.ghost.dto.BoardDTO;

@Controller 
public class BoardController {

	@Autowired 
	BoardDAO boardDAO ; 
	
	@RequestMapping(value="/board/{link}", method=RequestMethod.GET) 
	public String groupPage(@PathVariable("link") String link, Model model) {
		
		// TODO: 세션 값으로 id 확인 및 접근 권한 체크 우선
		// 		link가 실존 하는지 체크, link에 대한 권한 체크
		
		BoardDTO boardDTO = boardDAO.getBoard(link);
		model.addAttribute("u", boardDTO);
		return "board"; 
	}
	
	
	// Test를 위해 임시로 controller 만듬. makePost 를 위한 controller 필요
	@RequestMapping(value="/testurl") 
	public String makePost(HttpServletRequest request, Model model) {
		
		return "makePost"; 
	}
	
	@RequestMapping(value="/uploadOk", method=RequestMethod.POST) 
	public ModelAndView makePostOk(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView();
		// TODO: 세션 값으로 id 확인 및 접근 권한 체크 우선
		// 		link가 실존 하는지 체크, link에 대한 권한 체크
		//      Group은 어떻게 체크?

		int type = 0;
		String s_type = request.getParameter("type");
		if(s_type.equals("notice")) {
			type = 1;
		} else if (s_type.equals("notes")) {
			type = 2;
		} else if (s_type.equals("question")) {
			type = 3;
		} else if (s_type.equals("assignment")) {
			type = 4;
		} else {
			// Error handling
		}
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(title != null && content != null) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setType(type);
			boardDTO.setTitle(title);
			boardDTO.setContent(content);
			
			boardDAO.createPost(boardDTO);
			
			
			// return cases 검토 필요
			
			mav.setViewName("redirect:/board"); // + link 구현 필요
		} else {
			mav.setViewName("redirect:/error/loginError"); // different error? 
		}
		return mav; 
	}
	
	
	

//	@RequestMapping(value="/boardList", method=RequestMethod.POST)
//	public ViewAndModel boardList(HttpServletRequest request, Model model) {
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
