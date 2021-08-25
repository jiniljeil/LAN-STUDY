package com.security.ghost.dao;

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
}
