package com.security.ghost.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.ghost.dto.GroupUserDTO;
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
	
	public List<GroupUserDTO> groupUserList(int group_id){
		return sqlSession.selectList("UserMapper.groupUserList", group_id);
	}
	
	public UserDTO getUserInfo(int user_id) {
		return sqlSession.selectOne("UserMapper.getUserInfo", user_id);
	}
	public String chkUser(HashMap<String ,Integer > info) {
		int cnt = sqlSession.selectOne("UserMapper.chkUser", info);
		if(cnt==0) return "false";
		return "true";
	}
	public String chkManager(HashMap<String ,Integer > info) {
		int cnt = sqlSession.selectOne("UserMapper.chkUser", info);
		if(cnt==0) return "false";
		
		int auth = sqlSession.selectOne("UserMapper.chkManager", info);
		if(auth==0 || auth==1) return "true";
		return "false";
	}

}
