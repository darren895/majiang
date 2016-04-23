package com.majiang.entity;

import java.io.Serializable;

public class Fan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7867090716091662110L;

	private int id;
	
	private String name;
	
	private int score;
	
	private String except;
	
	private int unique;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getExcept() {
		return except;
	}

	public void setExcept(String except) {
		this.except = except;
	}

	public int getUnique() {
		return unique;
	}

	public void setUnique(int unique) {
		this.unique = unique;
	}
	
	

}
