package com.majiang.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.majiang.entity.Fight;

public interface FightMapper {

	void insertFight(Fight fight);
	
	Fight getFightByKey(@Param("id")int id);
	
	List<Fight> getFightByGameId(@Param("gameId")int gameId);
	
	Map<String, Integer> getSumScore(@Param("gameId")int gameId);
	
	int updateFight(Fight fight);
}
