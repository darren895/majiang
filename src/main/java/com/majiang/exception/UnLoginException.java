package com.majiang.exception;

public class UnLoginException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988849265634875868L;

	public UnLoginException() {
	}

	public UnLoginException(String s) {
		super(s);
	}

	public UnLoginException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public UnLoginException(Throwable throwable) {
		super(throwable);
	}

	protected UnLoginException(String s, Throwable throwable, boolean flag, boolean flag1) {
		super(s, throwable, flag, flag1);
	}

	@Override
	public String getMessage() {
		return "未登录";
	}
}
