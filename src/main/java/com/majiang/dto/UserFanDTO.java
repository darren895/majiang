package com.majiang.dto;

import java.io.Serializable;
/**
 * 用户番种统计DTO
 * @author darren
 *
 */

import com.majiang.entity.Fan;
public class UserFanDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2610953124341738612L;

	private int fanId;
	
	private Fan fan;
	
	private int count;

	public int getFanId() {
		return fanId;
	}

	public void setFanId(int fanId) {
		this.fanId = fanId;
	}

	public Fan getFan() {
		return fan;
	}

	public void setFan(Fan fan) {
		this.fan = fan;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
