package com.majiang.entity;

import java.io.Serializable;
import java.util.Date;

public class Game implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4476397508856382192L;

	private int id;
	
	private int eastId;
	
	private int westId;
	
	private int northId;
	
	private int southId;
	
	private User east;
	
	
	private User west;
	
	private User north;
	
	private User south;
	
	private Date startTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public int getEastId() {
		return eastId;
	}

	public void setEastId(int eastId) {
		this.eastId = eastId;
	}

	public int getWestId() {
		return westId;
	}

	public void setWestId(int westId) {
		this.westId = westId;
	}

	public int getNorthId() {
		return northId;
	}

	public void setNorthId(int northId) {
		this.northId = northId;
	}

	public int getSouthId() {
		return southId;
	}

	public void setSouthId(int southId) {
		this.southId = southId;
	}

	public User getEast() {
		return east;
	}

	public void setEast(User east) {
		this.east = east;
	}

	public User getWest() {
		return west;
	}

	public void setWest(User west) {
		this.west = west;
	}

	public User getNorth() {
		return north;
	}

	public void setNorth(User north) {
		this.north = north;
	}

	public User getSouth() {
		return south;
	}

	public void setSouth(User south) {
		this.south = south;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getUserId(String user){
		switch (user) {
		case "east":
			return east.getId();
		case "west":
			return west.getId();
		case "south":
			return south.getId();
		case "north":
			return north.getId();
		}
		return 0;
	}
}
