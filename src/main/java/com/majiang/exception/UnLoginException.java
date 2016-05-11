package com.majiang.exception;

public class UnLoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988849265634875868L;

	@Override
	public String getMessage() {
		return "未登录";
	}
}
