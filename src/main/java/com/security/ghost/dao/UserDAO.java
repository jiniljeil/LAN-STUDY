package com.security.ghost.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.ghost.dto.UserDTO;

@Repository
public class UserDAO {
	
	@Autowired
	SqlSession sqlSession; 
	
	public UserDTO getUser(String userid) {
		return sqlSession.selectOne("UserMapper.getUser", userid); 
	}
}
