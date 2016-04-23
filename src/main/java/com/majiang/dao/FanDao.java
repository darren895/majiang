package com.majiang.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.majiang.entity.Fan;

@Repository
public class FanDao extends SqlSessionDaoSupport {
	
	public List<Fan> getAll(){
		return getSqlSession().selectList("fan.getAll");
	}
	
	public Fan getFanbyId(int id){
		return getSqlSession().selectOne("fan.getFanById", id);
	}

}
