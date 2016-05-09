package com.majiang.entity;

import java.io.Serializable;

public class MobileUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4480907841193300375L;

	public String uuid;
	
	public Integer userId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(!(obj instanceof MobileUser)){
			return false;
		}
		if(obj == this){
			return true;
		}
		MobileUser mobileUser = (MobileUser) obj;
		if(userId != mobileUser.userId && userId != null && !userId.equals(mobileUser.userId)){
			return false;
		}
		if(uuid != mobileUser.uuid && uuid != null && !uuid.equals(mobileUser.uuid)){
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		String s = uuid + userId;
		return s.hashCode();
	}
}
