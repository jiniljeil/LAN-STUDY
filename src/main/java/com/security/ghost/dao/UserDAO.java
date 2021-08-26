package com.security.ghost.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.ghost.dto.SaltDTO;
import com.security.ghost.dto.UserDTO;

@Repository
public class UserDAO {
	
	@Autowired
	SqlSession sqlSession; 
	
	public UserDTO getUserById(String userid) {
		return sqlSession.selectOne("UserMapper.getUserById", userid); 
	}

	public UserDTO getUser(UserDTO userDTO) {
		return sqlSession.selectOne("UserMapper.getUser", userDTO);
	}

	public List<UserDTO> getUserList() {
		return sqlSession.selectList("UserMapper.getUserList");
	}
	
	public byte[] getSalt(int userid) {
		return sqlSession.selectOne("UserMapper.getSalt", userid); 
	}
	
	public int joinUser(UserDTO userDTO) {
		return sqlSession.insert("UserMapper.joinUser", userDTO); 
	}
	
	public int getID(String userid) {
		return sqlSession.selectOne("UserMapper.getID", userid); 
	}
	
	public int storeSalt(SaltDTO saltDTO) {
		return sqlSession.insert("UserMapper.storeSalt",saltDTO); 
	}
	public int idDupCheck(String id) {
		return sqlSession.selectOne("UserMapper.idDupCheck", id);
	}

}
