package com.majiang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majiang.dao.FightDao;
import com.majiang.entity.Fight;

@Service
public class FightService {

	@Autowired
	private FightDao fightDao;
	
	public List<Fight> getFightByGameId(int gameId){
		return fightDao.getFightByGameId(gameId);
	}
	
	public Map<String, Integer> getScoreMap(int gameId){
		return fightDao.getFightScore(gameId);
	}
	
	public void insertFight(Fight fight){
		this.fightDao.insertFight(fight);
	}
	
	public boolean updateFight(Fight fight){
		return this.fightDao.updateFight(fight);
	}
	
	public Fight getFightById(int id){
		return fightDao.getFightById(id);
	}
}
