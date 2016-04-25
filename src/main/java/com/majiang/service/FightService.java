package com.majiang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majiang.entity.Fight;
import com.majiang.mapper.FightMapper;

@Service
public class FightService {

//	@Autowired
//	private FightDao fightDao;
	@Autowired
	private FightMapper fightMapper;
	
	public List<Fight> getFightByGameId(int gameId){
		return fightMapper.getFightByGameId(gameId);
	}
	
	public Map<String, Integer> getScoreMap(int gameId){
		return fightMapper.getSumScore(gameId);
	}
	
	public void insertFight(Fight fight){
		this.fightMapper.insertFight(fight);
	}
	
	public boolean updateFight(Fight fight){
		return this.fightMapper.updateFight(fight)>0;
	}
	
	public Fight getFightById(int id){
		return fightMapper.getFightByKey(id);
	}
}
