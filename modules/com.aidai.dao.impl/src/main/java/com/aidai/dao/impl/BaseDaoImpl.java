package com.aidai.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aidai.dao.BaseDao;
import com.aidai.dao.DaoException;
import com.aidai.dao.Page;
import com.aidai.utils.GenericsUtils;


public class BaseDaoImpl<T, F> extends AbstractIbatisDao<T, F>implements BaseDao<T, F> {
	private static final Log log = LogFactory.getLog(BaseDaoImpl.class);
	/**
	 * DAO所管理的Entity类型.
	 */
	protected Class<T> entityClass;

	/**
	 * 在构造函数中将泛型T.class赋给entityClass.
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() throws DaoException {
		entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}
	/**
	 * 保存对象.
	 * @throws DaoException
	 */
	public String insert(T o) throws DaoException {
		return super.insert(o);
	}
	/**
	 * 根据ID获取对象.
	 */
	public T findByPrimarykey(Serializable id) throws DaoException {
		return get(getEntityClass(), id);
	}
	/**
	 * 取得entityClass.
	 */
	protected Class<T> getEntityClass() throws DaoException {
		return entityClass;
	}
	/*
	 * public int update(G o) throws DaoException { return super.update(o); }
	 */
	// public List<T> queryForList(String statementId, Object parameters) throws DaoException {
	// return super.queryForList(getEntityClass(), statementId, parameters);
	// }
	// public T queryForObject(String statementId, Object parameters) throws DaoException {
	// return super.queryForObject(getEntityClass(), statementId, parameters);
	// }
	/*
	 * public int update(String statementId, Object parameters) throws DaoException { return
	 * super.update(getEntityClass(), statementId, parameters); }
	 */
	@Override
	public int countByExample(F example) throws DaoException {
		try {
			return super.countByExample(example);
		} catch (DaoException e) {
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
	@Override
	public int deleteByExample(F example) throws DaoException {
		try {
			return super.deleteByExample(example);
		} catch (DaoException e) {
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
	@Override
	public String insertSelective(T record) throws DaoException {
		try {
			return super.insert(record);
		} catch (DaoException e) {
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
	@Override
	public List<T> selectByExample(F example) throws DaoException {
		try {
			return super.selectByExample(example);
		} catch (DaoException e) {
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
	@Override
	public int updateByExampleSelective(T record, F example) throws DaoException {
		try {
			return super.updateByExampleSelective(record, example);
		} catch (DaoException e) {
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
	@Override
	public int updateByExample(T record, F example) throws DaoException {
		try {
			return super.updateByExample(record, example);
		} catch (DaoException e) {
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
	@Override
	public int deleteByPrimarykey(Serializable id) throws DaoException {
		return super.deleteByPrimarykey(getEntityClass(), id);
	}
	public T queryForObject(String statementId, Object parameters) throws DaoException{
		try{
			return super.queryForObject(getEntityClass(), statementId, parameters);
		}catch(DaoException e){
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
	public List<T> queryForList(String statementId, Object parameters)
			throws DaoException {
		try{
			return super.queryForList(getEntityClass(), statementId, parameters);
		}catch(DaoException e){
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
	public int update(String statementId, Object parameters) throws DaoException {
		try{
			return super.update(getEntityClass(), statementId, parameters);
		}catch(DaoException e){
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
	
	@Override
	public Page<T> selectByExample(int start, int limit, F example) throws DaoException {
		try{
			return super.selectByExample(start, limit, example);
		}catch(DaoException e){
			log.error("code:" + e.getCode() + ",msg:" + e.getMsg());
			throw new DaoException(e);
		}
	}
}
