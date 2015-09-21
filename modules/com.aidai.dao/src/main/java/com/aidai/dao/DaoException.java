package com.aidai.dao;

public class DaoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	private String code;
	
	public DaoException(DaoException e) {
		this.msg = e.getMsg();
		this.code = e.getCode();
	}
	
	public DaoException(String code,String msg) {
		this.msg = msg;
		this.code = code;
	}
	
	public DaoException(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
