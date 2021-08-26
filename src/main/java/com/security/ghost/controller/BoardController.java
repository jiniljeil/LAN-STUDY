package com.security.ghost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.security.ghost.SecurityUtil;
import com.security.ghost.dao.BoardDAO;
import com.security.ghost.dao.GroupDAO;
import com.security.ghost.dto.BoardDTO;
import com.security.ghost.dto.CommentDTO;

@RestController 
public class BoardController {

	@Autowired 
	BoardDAO boardDAO ; 
	
	@Autowired
	GroupDAO groupDAO;
	
	@RequestMapping(value="/board/{link}") 
	public ModelAndView getGroup(@PathVariable("link") String link, Model model, HttpSession session) {
		
		// TODO: 세션 값으로 id 확인 및 접근 권한 체크 우선
		// 		link가 실존 하는지 체크, lin/에 대한 권한 체크
		ModelAndView mav = new ModelAndView(); 
		// TODO Session 을 통한 접근 제한 (CSRF)
		int group_id = groupDAO.getGroupId(link); 
		
		if (link != null) {
			group_id = boardDAO.getGroupID(link);
		}else {
			//TODO 에러 창으로 넘어가기 
		}
		
		// TODO 사용자가 그룹 아아디에 속하는지 체크 
		model.addAttribute("link", link);
		if (true) {
			List<BoardDTO> boardList = boardDAO.getBoardList(group_id); 
			if (boardList != null) {
				model.addAttribute("boardList", boardList); 
				mav.setViewName("board"); 
			}else {
				// TODO 에러 페이지로 
			}
		}else {
			// 권한이 없으면 에러 페이지로 
//			TODO mav.setViewName("redirect:error"); 
		}
		return mav; 
	}
	
	@RequestMapping(value="/board/{link}/comment")
	public List<CommentDTO> getComment(@PathVariable("link") String link, @RequestParam("id") String id, Model model, HttpSession session) {
		int board_id = -1;
		
		if (id != null) {
			board_id = Integer.parseInt(id); 

			List<CommentDTO> commentList = boardDAO.getCommentList(board_id);
			if (commentList != null) {
				//model.addAttribute("commentList", commentList);
				return commentList ;
			}
		}
//		에러 페이지로 이동
//		mav.setViewName("redirect:/error/");
		return null; 
	}
	
	// Test를 위해 임시로 controller 만듬. makePost 를 위한 controller 필요
	@RequestMapping(value="/testurl") 
	public String makePost(HttpServletRequest request, Model model) {
		return "makePost"; 
	}


	@RequestMapping(value="/board/{link}/uploadOk", method=RequestMethod.POST) 
	public ModelAndView makePostOk(@PathVariable("link") String link, HttpServletRequest request, Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// TODO: 세션 값으로 id 확인 및 접근 권한 체크 우선
		// 		link가 실존 하는지 체크, link에 대한 권한 체크
		//      Group은 어떻게 체크?
		// 해당 유저가 실제로 Group 에 속해있는지 확인 
		
		int type = 0;
		String s_type = request.getParameter("Category");
		
		if (s_type != null) {
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
		}else {
			// Error handling
		}
		
		int user_id = Integer.parseInt(session.getAttribute("id").toString());
		int group_id = groupDAO.getGroupId(link);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(title != null && content != null) {
			title = SecurityUtil.HTML_Filter(title); 
			content = SecurityUtil.HTML_Filter(content); 
			
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setUser_id(user_id);
			boardDTO.setGroup_id(group_id);
			boardDTO.setType(type);
			boardDTO.setTitle(title);
			boardDTO.setContent(content);
			
			boardDAO.createPost(boardDTO);
			
			// return cases 검토 필요
			
			mav.setViewName("redirect:/board/" + link); // + link 구현 필요
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
