package com.majiang.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.majiang.entity.Fight;

@Repository
public class FightDao extends SqlSessionDaoSupport {

	public void insertFight(Fight fight){
		getSqlSession().insert("fight.insertFight", fight);
	}
	
	public Fight getFightById(int id){
		return getSqlSession().selectOne("fight.getFightByKey", id);
	}
	
	public List<Fight> getFightByGameId(int gameId){
		return getSqlSession().selectList("fight.getFightByGameId", gameId);
	}
	
	public Map<String, Integer> getFightScore(int gameId){
		return getSqlSession().selectOne("fight.getSumScore", gameId);
	}
	
	public boolean updateFight(Fight fight){
		return getSqlSession().update("fight.updateFight", fight) > 0;
	}
}
