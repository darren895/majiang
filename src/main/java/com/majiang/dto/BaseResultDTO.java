package com.majiang.dto;

import java.io.Serializable;

public class BaseResultDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5383474398982967758L;

	private boolean result;
	
	private String message;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
