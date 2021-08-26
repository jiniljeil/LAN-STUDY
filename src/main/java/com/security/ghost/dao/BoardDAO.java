package com.security.ghost.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.ghost.dto.BoardDTO;
import com.security.ghost.dto.CommentDTO;

@Repository
public class BoardDAO {
	@Autowired 
	SqlSession sqlSession ;
	
	public int createPost(BoardDTO boardDTO) {
		return sqlSession.insert("BoardMapper.createPost", boardDTO);
	}
	
	public int getGroupID(String link) {
		return sqlSession.selectOne("BoardMapper.getGroupId", link);
	}
	
	public List<BoardDTO> getBoardList(int group_id) {
		return sqlSession.selectList("BoardMapper.getBoardList", group_id);
	}

	public List<CommentDTO> getCommentList(int board_id) {
		return sqlSession.selectList("BoardMapper.getCommentList", board_id); 
	}

}
