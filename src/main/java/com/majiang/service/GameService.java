package com.majiang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majiang.entity.Game;
import com.majiang.mapper.GameMapper;

@Service
public class GameService {
//	@Autowired
//	private GameDao gameDao;
	@Autowired
	private UserService userService;
	@Autowired
	private GameMapper gameMapper;
	
	public void saveGame(Game game){
		if(game.getId()==0){
			saveGameUser(game);
			gameMapper.insertGame(game);
		}
	}
	
	private void saveGameUser(Game game){
		if(game == null){
			return;
		}
		if(game.getEast()!= null){
			userService.fillUser(game.getEast());
			game.setEastId(game.getEast().getId());
		}
		if(game.getWest()!= null){
			userService.fillUser(game.getWest());
			game.setWestId(game.getWest().getId());
		}
		if(game.getSouth()!= null){
			userService.fillUser(game.getSouth());
			game.setSouthId(game.getSouth().getId());
		}
		if(game.getNorth()!= null){
			userService.fillUser(game.getNorth());
			game.setNorthId(game.getNorth().getId());
		}
	}
	
	public Game getGame(int id){
		Game game = gameMapper.getGame(id);
		fillGame(game);
		return game;
	}
	
	public List<Game> getGames(int page,int size){
		int start = (page-1) * size;
		List<Game> games = gameMapper.getGamesByPage(start, size);
		if(games != null && !games.isEmpty()){
			for (Game game : games) {
				fillGame(game);
			}
		}
		return games;
	}
	
	private void fillGame(Game game){
		if(game != null){
			game.setEast(userService.getUser(game.getEastId()));
			game.setWest(userService.getUser(game.getWestId()));
			game.setSouth(userService.getUser(game.getSouthId()));
			game.setNorth(userService.getUser(game.getNorthId()));
		}
	}
	
	
}
