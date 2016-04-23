package com.majiang.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Fight implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7179161416860587266L;

	private int id;
	
	private int gameId;
	
	private int east;
	
	private int west;
	
	private int south;
	
	private int north;
	
	private String score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getEast() {
		return east;
	}

	public void setEast(int east) {
		this.east = east;
	}

	public int getWest() {
		return west;
	}

	public void setWest(int west) {
		this.west = west;
	}

	public int getSouth() {
		return south;
	}

	public void setSouth(int south) {
		this.south = south;
	}

	public int getNorth() {
		return north;
	}

	public void setNorth(int north) {
		this.north = north;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public void fillEmpty(){
		gameId = 0;
		east=0;
		west=0;
		south=0;
		north=0;
		score="";
	}
	
	public void setResult(String user,int score){
		try {
			getClass().getDeclaredField(user).setInt(this, score);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public String getWinner(){
		if(east>0){
			return "east";
		}
		if(west>0){
			return "west";
		}
		if(south>0){
			return "south";
		}
		if(north>0){
			return "north";
		}
		return null;
	}
	
	public String getLoser(){
		int loserNum = 0;
		String loser = null;
		if(east<0){
			loserNum++;
			loser = "east";
		}
		if(west<0){
			loserNum++;
			loser = "west";
		}
		if(south<0){
			loserNum++;
			loser = "south";
		}
		if(north<0){
			loserNum++;
			loser = "north";
		}
		if(loserNum>1){
			return null;
		}
		return loser;
	}
}
