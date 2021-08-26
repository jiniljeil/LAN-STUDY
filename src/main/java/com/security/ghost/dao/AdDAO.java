package com.security.ghost.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.ghost.dto.AdDTO;
import com.security.ghost.dto.BoardDTO;

@Repository
public class AdDAO {
	@Autowired
	SqlSession sqlSession; 
	
	public List<AdDTO> getAdList() {
		return sqlSession.selectList("AdMapper.getAdList"); 
	}
	
	public int uploadAd(AdDTO AdDTO) {
		return sqlSession.insert("AdMapper.uploadAd", AdDTO); 
	} 
	
}
