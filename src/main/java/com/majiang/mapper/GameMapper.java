package com.majiang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.majiang.entity.Game;

public interface GameMapper {
	
	void insertGame(Game game);
	
	Game getGame(@Param("id")int id);

	List<Game> getGamesByPage(@Param("start")int start,@Param("size")int size);
}
