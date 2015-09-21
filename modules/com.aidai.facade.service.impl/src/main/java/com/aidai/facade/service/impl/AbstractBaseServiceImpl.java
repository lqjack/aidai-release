package com.aidai.facade.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aidai.dao.Page;
import com.aidai.service.BaseService;
import com.aidai.service.ServiceException;
@Transactional
public abstract class AbstractBaseServiceImpl<T, F> extends ServiceTemplate<T, F>implements BaseService<T, F> {
	@Override
	public String insert(T o) throws ServiceException {
		setBaseDao();
		String result = null;
		insertBefore(o);
		result = super.insert(o);
		insertAfter(o);
		return result;
	}

	@Override
	public int countByExample(F example) throws ServiceException {
		setBaseDao();
		int result = 0;
		countByExampleBefore(example);
		result = super.countByExample(example);
		countByExampleAfter(example);
		return result;
	}

	@Override
	public int deleteByExample(F example) throws ServiceException {
		setBaseDao();
		int result = 0;
		deleteByExampleBefore(example);
		result = super.deleteByExample(example);
		deleteByExampleAfter(example);
		return result;
	}

	@Override
	public String insertSelective(T record) throws ServiceException {
		setBaseDao();
		String result = null;
		insertSelectiveBefore(record);
		result = super.insertSelective(record);
		insertSelectiveAfter(record);
		return result;
	}

	@Override
	public List<T> selectByExample(F example) throws ServiceException {
		setBaseDao();
		List<T> result = null;
		selectByExampleBefore(example);
		result = super.selectByExample(example);
		selectByExampleAfter(example);
		return result;
	}

	@Override
	public int updateByExampleSelective(T record, F example) throws ServiceException {
		setBaseDao();
		int result = 0;
		updateByExampleSelectiveBefore(record, example);
		result = super.updateByExampleSelective(record, example);
		updateByExampleSelectiveAfter(record, example);
		return result;
	}

	@Override
	public int updateByExample(T record, F example) throws ServiceException {
		setBaseDao();
		int result = 0;
		updateByExampleBefore(record, example);
		result = super.updateByExample(record, example);
		updateByExampleAfter(record, example);
		return result;
	}

	@Override
	public int deleteByPrimarykey(Serializable id) throws ServiceException {
		setBaseDao();
		int result = 0;
		deleteByPrimarykeyBefore(id);
		result = super.deleteByPrimarykey(id);
		deleteByPrimarykeyAfter(id);
		return result;
	}

	@Override
	public T findByPrimarykey(Serializable id) throws ServiceException {
		setBaseDao();
		T result = null;
		findByPrimarykeyBefore(id);
		result = super.findByPrimarykey(id);
		findByPrimarykeyAfter(result,id);
		return result;
	}

	@Override
	public T queryForObject(String statementId, Object parameters) throws ServiceException {
		setBaseDao();
		T result = null;
		queryForObjectBefore(statementId, parameters);
		result = super.queryForObject(statementId, parameters);
		queryForObjectAfter(statementId, parameters);
		return result;
	}

	@Override
	public List<T> queryForList(String statementId, Object parameters) throws ServiceException {
		setBaseDao();
		List<T> result = null;
		queryForListBefore(statementId, parameters);
		result = super.queryForList(statementId, parameters);
		queryForListAfter(statementId, parameters);
		return result;
	}

	@Override
	public int update(String statementId, Object parameters) throws ServiceException {
		setBaseDao();
		int result = 0;
		updateBefore(statementId, parameters);
		result = super.update(statementId, parameters);
		updateAfter(statementId, parameters);
		return result;
	}

	@Override
	public Page<T> selectByExample(int start, int limit, F example) throws ServiceException {
		setBaseDao();
		Page<T> result = null;
		selectByExampletBefore(start, limit, example);
		result = super.selectByExample(start, limit, example);
		selectByExampleAfter(start, limit, example);
		return result;
	}
}
