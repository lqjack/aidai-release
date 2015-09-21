/**   
 * Copyright © 2015 公司名. All rights reserved.
 * 
 * @Title: BaseServiceImpl.java 
 * @Prject: qlc
 * @Package: com.hl.qlc.base.service 
 * @Description: TODO
 * @author: Administrator   
 * @date: 2015年7月27日 上午11:57:52 
 * @version: V1.0   
 */
package com.aidai.facade.service.impl;

import java.io.Serializable;

import com.aidai.service.BaseService;
import com.aidai.service.ServiceException;

/** 
 * @ClassName: BaseServiceImpl 
 * @Description: TODO
 * @author: Administrator
 * @date: 2015年7月27日 上午11:57:52  
 */
public abstract class BaseServiceImpl<T,F> extends AbstractBaseServiceImpl<T, F> implements BaseService<T, F> {
	

	@Override
	protected
	void insertBefore(T o) throws ServiceException{
	}

	@Override
	protected void insertAfter(T o) throws ServiceException {
	}

	@Override
	protected void countByExampleBefore(F example) throws ServiceException {
	}

	@Override
	protected void countByExampleAfter(F example) throws ServiceException {
	}

	@Override
	protected void deleteByExampleBefore(F example) throws ServiceException {
	}

	@Override
	protected void deleteByExampleAfter(F example) throws ServiceException {
	}

	@Override
	protected void insertSelectiveBefore(T record) throws ServiceException {
	}

	@Override
	protected void insertSelectiveAfter(T record) throws ServiceException {
	}

	@Override
	protected void selectByExampleBefore(F example) throws ServiceException {
	}

	@Override
	protected void selectByExampleAfter(F example) throws ServiceException {
	}

	@Override
	protected void updateByExampleSelectiveBefore(T record, F example) throws ServiceException {
	}

	@Override
	protected void updateByExampleSelectiveAfter(T record, F example) throws ServiceException {
	}

	@Override
	protected void updateByExampleBefore(T record, F example) throws ServiceException {
	}

	@Override
	protected void updateByExampleAfter(T record, F example) throws ServiceException {
	}

	@Override
	protected void deleteByPrimarykeyBefore(Serializable id) throws ServiceException {
	}

	@Override
	protected void deleteByPrimarykeyAfter(Serializable id) throws ServiceException {
	}

	@Override
	protected void findByPrimarykeyBefore(Serializable id) throws ServiceException {
	}

	@Override
	protected void findByPrimarykeyAfter(T o,Serializable id) throws ServiceException {
	}

	@Override
	protected void queryForObjectBefore(String statementId, Object parameters) throws ServiceException {
	}

	@Override
	protected void queryForObjectAfter(String statementId, Object parameters) throws ServiceException {
	}

	@Override
	protected void updateBefore(String statementId, Object parameters) throws ServiceException {
	}

	@Override
	protected void updateAfter(String statementId, Object parameters) throws ServiceException {
	}

	@Override
	protected void queryForListBefore(String statementId, Object parameters) throws ServiceException {
	}

	@Override
	protected void queryForListAfter(String statementId, Object parameters) throws ServiceException {
	}
	
	@Override
	protected void selectByExampletBefore(int start, int limit, F example) throws ServiceException {
	}
	
	@Override
	protected void selectByExampleAfter(int start, int limit, F example) throws ServiceException {
	}

//	@Override
//	protected abstract void ServiceTemplate(BaseDao<T, F> baseDao);
}
