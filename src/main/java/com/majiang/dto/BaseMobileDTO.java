package com.majiang.dto;

import java.io.Serializable;

public class BaseMobileDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6160640301296540468L;

	private String token;
	
	private Long time;
	
	private String uuid;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
