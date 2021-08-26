package com.security.ghost.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.ghost.dto.GroupDTO;

@Repository
public class GroupDAO {
	@Autowired 
	SqlSession sqlSession ;
	
	public int createGroup(GroupDTO groupDTO) {
		return sqlSession.insert("GroupMapper.createGroup", groupDTO);
	}
	
	//public int createJoin() {
	//	return sqlSession.insert("GroupMapper.createGroup", groupDTO);
	//}
	
	public List<GroupDTO> groupList(int user_id){
		return sqlSession.selectList("GroupMapper.groupListbyUserId", user_id);
	}
}
