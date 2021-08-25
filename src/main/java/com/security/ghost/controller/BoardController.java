package com.security.ghost.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.ghost.dao.BoardDAO;
import com.security.ghost.dto.BoardDTO;

@Controller 
public class BoardController {

	@Autowired 
	BoardDAO boardDAO ; 
	
	@RequestMapping(value="/board", method=RequestMethod.POST) 
	public String BoardOk(HttpServletRequest request) {
		String title = request.getParameter("title"); 
		// 이미지 처리 업로드 ?
		String content = request.getParameter("content"); 
		
		// XSS BLOCK 
		// encodeforhtml 
		title = title.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
				.replaceAll("\\", "&quot;").replaceAll("\'", "&#x27").replaceAll("/", "&#x2F")
				.replaceAll("(", "&#x28;").replaceAll(")", "&#x29;");
		
		content = content.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
					.replaceAll("\\", "&quot;").replaceAll("\'", "&#x27").replaceAll("/", "&#x2F")
					.replaceAll("(", "&#x28;").replaceAll(")", "&#x29;");
		
		if (title != null && content != null) {
			BoardDTO boardDTO = new BoardDTO(); 
			
			boardDTO.setTitle(title); 
			// 이미지 포함해야함 
			boardDTO.setContent(content);
			
			boardDAO.uploadBoard(boardDTO);
			return "homePage"; 
		}else {
			// 업로드 실패 혹은 제목 및 내용 입력 요구 
			return "makeStudy"; 
		}
	}
}
