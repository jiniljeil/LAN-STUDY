package com.security.ghost.controller;

import java.util.HashMap;
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
import com.security.ghost.dao.UserDAO;
import com.security.ghost.dto.BoardDTO;
import com.security.ghost.dto.CommentDTO;
import com.security.ghost.dto.GroupUserDTO;

@RestController 
public class BoardController {

	@Autowired 
	BoardDAO boardDAO ; 
	
	@Autowired
	UserDAO userDAO; 
	
	@Autowired
	GroupDAO groupDAO;
	
	@RequestMapping(value="/board/{link}") 
	public ModelAndView getGroup(@PathVariable("link") String link, Model model, HttpSession session) {
		
		ModelAndView mav = new ModelAndView(); 
		// TODO Session 을 통한 접근 제한 (CSRF)
		int group_id = -1 ; 
		if (link != null) {
			group_id = groupDAO.getGroupId(link); 
		}else { 
			mav.setViewName("redirect:/error/linkError"); 
			return mav;
		}
		String id = session.getAttribute("id").toString(); 
		
		int user_id = -1; 
		if( id != null) {
			user_id = Integer.parseInt(id);
		}
		
		HashMap<String, Integer> info = new HashMap<String, Integer>();
		info.put("group_id" , group_id);
		info.put("user_id", user_id);
		if(userDAO.chkUser(info).equals("false")) {
			mav.setViewName("redirect:/error/accessError");
			return mav;
		}
		
		group_id = boardDAO.getGroupID(link);
		
		List<BoardDTO> boardList = boardDAO.getBoardList(group_id); 
		if (boardList != null) {
			model.addAttribute("boardCnt", boardList.size());
			model.addAttribute("boardList", boardList); 
			mav.setViewName("board"); 
		}else {
			mav.setViewName("redirect:/error/accessError");
		}
		return mav; 
	}
	
	@RequestMapping(value="/board/{link}/comment")
	public List<CommentDTO> getComment(@PathVariable("link") String link, @RequestParam("id") String id, Model model, HttpSession session) {
		int board_id = -1;
		int group_id = groupDAO.getGroupId(link); 
		
		String u_id = session.getAttribute("id").toString(); 
		int user_id = -1; 
		
		if(u_id != null) {
			user_id = Integer.parseInt(u_id);
		}
		
		HashMap<String, Integer> info = new HashMap<String, Integer>();
		info.put("group_id" , group_id);
		info.put("user_id", user_id);
		if(userDAO.chkUser(info).equals("false")) {
			return null;
		}
		if (id != null) {
			board_id = Integer.parseInt(id); 

			List<CommentDTO> commentList = boardDAO.getCommentList(board_id);
			if (commentList != null) {
				//model.addAttribute("commentList", commentList);
				return commentList ;
			}
		}

		return null; 
	}


	@RequestMapping(value="/board/{link}/uploadOk", method=RequestMethod.POST) 
	public ModelAndView makePostOk(@PathVariable("link") String link, HttpServletRequest request, Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		int group_id = groupDAO.getGroupId(link); 
		int user_id = Integer.parseInt(session.getAttribute("id").toString());
		
		HashMap<String, Integer> info = new HashMap<String, Integer>();
		info.put("group_id" , group_id);
		info.put("user_id", user_id);
		
		if(userDAO.chkUser(info).equals("false")) {
			mav.setViewName("redirect:/error/accessError");
			return mav;
		}
		
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
				mav.setViewName("redirect:/error/accessError");
			}
		}else {
			mav.setViewName("redirect:/error/accessError");
		}
		
		String id = session.getAttribute("id").toString(); 

		if (id != null) {
			user_id = Integer.parseInt(id);
		}
		
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
			
			mav.setViewName("redirect:/board/" + link); // + link 구현 필요
		} else {
			mav.setViewName("redirect:/error/loginError"); // different error? 
		}
		return mav; 
	}
	
	@RequestMapping(value="/board/{link}/commentWrite", method=RequestMethod.POST) 
	public CommentDTO uploadComment(@PathVariable("link") String link, @RequestParam("comment") String comment, @RequestParam("id") String board_id, HttpSession session) {
		CommentDTO commentDTO = null; 
		
		
		if (comment != null) {
			comment = SecurityUtil.HTML_Filter(comment); 
			commentDTO = new CommentDTO(); 
			String s = (String)session.getAttribute("id") ;
			if ( s != null ) {
				commentDTO.setUser_id(Integer.parseInt(s.toString())); 
			}
			
			if (board_id != null) {
				commentDTO.setBoard_id(Integer.parseInt(board_id));
			}
			
			commentDTO.setContent(comment);
			
			boardDAO.createComment(commentDTO);
		}
		return commentDTO; 
	}
	
	@RequestMapping(value="/board/{link}/manage/user", method=RequestMethod.GET)
	public ModelAndView manageUser(@PathVariable("link") String link, Model model, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		int group_id = groupDAO.getGroupId(link); 
		String id = session.getAttribute("id").toString(); 
		int user_id = -1 ; 
		if( id != null) {
			user_id = Integer.parseInt(id);
		}
		
		HashMap<String, Integer> info = new HashMap<String, Integer>();
		info.put("group_id" , group_id);
		info.put("user_id", user_id);
		if(userDAO.chkUser(info).equals("false")) {
			mav.setViewName("redirect:/error/accessError");
			return mav;
		}
		else if(userDAO.chkManager(info).equals("false")) {
			mav.setViewName("redirect:/error/accessError");
			return mav;
		}
		
		List<GroupUserDTO> user_list = userDAO.groupUserList(group_id);
		
		model.addAttribute("userList", user_list);
		model.addAttribute("userCnt", user_list.size());
		mav.setViewName("userManage");
		
		return mav;
	}
}