package com.security.ghost.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.ghost.dto.BoardDTO;
import com.security.ghost.dto.UserDTO;

@Repository
public class BoardDAO {
	@Autowired 
	SqlSession sqlSession ;
	
	
	

}
