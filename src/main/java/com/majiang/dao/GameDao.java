package com.majiang.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.majiang.entity.Game;

@Repository
public class GameDao extends SqlSessionDaoSupport {
	
	public void insertGame(Game game){
		getSqlSession().insert("game.insertGame", game);
	}

	public Game getGame(int id){
		return getSqlSession().selectOne("game.getGame", id);
	}
	
	public List<Game> getGames(int start,int size){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("size", size);
		return getSqlSession().selectList("game.getGamesByPage", param);
	}
}
