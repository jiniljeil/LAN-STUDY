package com.security.ghost.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.ghost.dto.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired 
	SqlSession sqlSession ;
	
	public int createPost(BoardDTO boardDTO) {
		return sqlSession.insert("BoardMapper.createPost", boardDTO);
	}
	
	public BoardDTO getBoard(String link) {
		return sqlSession.selectOne("BoardMapper.getBoard", link);
	}
	


}
