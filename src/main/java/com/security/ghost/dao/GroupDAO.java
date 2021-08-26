package com.security.ghost.dao;

import java.util.HashMap;
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
	
	public int createJoin(HashMap<String ,Integer > joinInfo) {
		return sqlSession.insert("GroupMapper.createJoin", joinInfo);
	}
	
	public List<GroupDTO> groupList(int user_id){
		return sqlSession.selectList("GroupMapper.groupListbyUserId", user_id);
	}
	
	public int getGroupId (String link) {
		return sqlSession.selectOne("GroupMapper.getGroupId", link);
	}
	public GroupDTO getGroupById (int id) {
		return sqlSession.selectOne("GroupMapper.getGroupById", id);
	}
}
