package com.aidai.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aidai.dao.DaoException;

public class ServiceException extends Exception {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger log = LoggerFactory.getLogger(ServiceException.class);

	private String msg;
	
	private String code;
	
	public ServiceException(String code,String msg) {
		log.error("error code : " + code  + "; msg :" + msg);
	}
	
	public ServiceException(String code) {
		log.error("error code : " + code );
	}

	public ServiceException(DaoException exception) {
		this.msg = exception.getMsg();
		this.code = exception.getCode();
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
