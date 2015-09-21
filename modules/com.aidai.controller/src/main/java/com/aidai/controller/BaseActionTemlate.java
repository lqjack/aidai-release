package com.aidai.controller;

import java.util.List;

import com.aidai.service.ServiceException;

public abstract class BaseActionTemlate<T, F> extends BaseAction<T,F> {
	
	protected abstract void setService();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	abstract void initBefore(T o,F example)throws ServiceException;
	
	abstract void initFindBefore(T o,F example)throws ServiceException;
	abstract void initFirstAfter(T o,F example)throws ServiceException;
	abstract void initSecondBefore(T o,F example)throws ServiceException;
	
	abstract void initAfter(T o,F example,List<T> items)throws ServiceException;
	
	abstract void addBefore(T o,F example)throws ServiceException;
	abstract void addAfter(T o,F example)throws ServiceException;
	
	abstract void modifyBefore(T oldModel,T o,F example)throws ServiceException;
	abstract void modifyAfter(T o,F example)throws ServiceException;
	
	abstract void updateBefore(T o,F example)throws ServiceException;
	abstract void updateAfter(T o,F example)throws ServiceException;
	
	abstract void delBefore(T o,F example)throws ServiceException;
	abstract void delAtfer(T o,F example)throws ServiceException;
	
	abstract void listBefore(T o,F example)throws ServiceException;
	abstract void listAtfer(T o,F example)throws ServiceException;
}
