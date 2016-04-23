package com.majiang.entity;

import java.io.Serializable;

public class FightFan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4592185828969322584L;

	private int id;
	
	private int fightId;
	
	private int userId;
	
	private int fanId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFightId() {
		return fightId;
	}

	public void setFightId(int fightId) {
		this.fightId = fightId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFanId() {
		return fanId;
	}

	public void setFanId(int fanId) {
		this.fanId = fanId;
	}
	
	

}
