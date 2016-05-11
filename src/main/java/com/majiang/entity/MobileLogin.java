package com.majiang.entity;

import java.io.Serializable;
import java.util.Date;

public class MobileLogin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -820312627015383338L;

	private String uuid;
	
	private Integer userId;
	
	private Date loginTime;
	
	private String tokenKey;
	
	private Integer status;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	

}
