package com.aidai.facade.service.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aidai.dao.BaseDao;
import com.aidai.dao.DaoException;
import com.aidai.dao.Page;
import com.aidai.service.ServiceException;
import com.aidai.utils.GenericsUtils;

public abstract class ServiceTemplate<T, F> {
	
	private static final Logger log = LoggerFactory.getLogger("service.template");
	
	public ServiceTemplate() {
		setBaseDao();
	}
	
//	@Autowired
	protected BaseDao<T, F> baseDao;
	
	private Class daoClass;
	private Object daoObject;
	private Class beanClass;
	private Object beanObject;
	private Class exampleClass;
	private Object exampleObject;
	
	@SuppressWarnings("rawtypes")
	private Class getDaoClass(){
		if(daoClass==null){
			String className = GenericsUtils.getSuperClassGenricType(this.getClass(), 0).toString();
			className = className.replace("class ", "");
			className = className.replace("model", "dao");
			className = className + "Dao";
			try {
				return daoClass = Class.forName(className);
			} catch (ClassNotFoundException e) {
				log.error(className + "未找到");
			}
		}
		return daoClass;
	}
	
	@SuppressWarnings("rawtypes")
	private Class getDaoImplClass(){
			String className = GenericsUtils.getSuperClassGenricType(this.getClass(), 0).toString();
			className = className.replace("class ", "");
			className = className.replace("model", "dao");
			String poix = className.substring(className.indexOf("dao") + 4);
			className = className.substring(0,className.indexOf("dao") + 3);
			className += ".impl." + poix;
			className = className + "DaoImpl";
			try {
				return  Class.forName(className);
			} catch (ClassNotFoundException e) {
				log.error(className + "未找到");
			}
			return null;
	}
	
	@SuppressWarnings("rawtypes")
	private Class getBeanClass(){
		if(beanClass==null){
			return beanClass = GenericsUtils.getSuperClassGenricType(this.getClass(), 0);
		}
		return beanClass;
	}
	
	@SuppressWarnings("rawtypes")
	private Class getExampleClass(){
		if(exampleClass==null){
			return exampleClass = GenericsUtils.getSuperClassGenricType(this.getClass(), 1);
		}
		return exampleClass;
	}
	
	@SuppressWarnings({"rawtypes" })
	private Method getMethod(String methodName,Class paramClass){
		Method method = null;
		try {
//			return getDaoClass().getClass().getSuperclass().getSuperclass().getMethod(methodName, paramClass);
			return getDaoObject().getClass().getMethod(methodName, paramClass);
//			method = getDaoClass().getMethod(methodName, paramClass);
//			if(method == null){
//				return getDaoClass().getGenericSuperclass().getClass().getMethod(methodName, paramClass);
//			}
		} catch (SecurityException e) {
			log.error("安全异常");
		} catch (NoSuchMethodException e) {
			log.error(e.getLocalizedMessage());
		}
		return null;
	}
	
	private Object getDaoObject(){
		if(daoObject==null){
			try {
//				return daoObject = getDaoClass().newInstance();
				return daoObject = getDaoImplClass().newInstance();
			} catch (InstantiationException e) {
				log.error(e.getMessage());
				log.error(daoObject + "实例化异常");
			} catch (IllegalAccessException e) {
				log.error("访问异常");
			}
		}
		return daoObject;
	}
	protected abstract void setBaseDao();
	
	abstract void insertBefore(T o) throws ServiceException;
	abstract void insertAfter(T o) throws ServiceException;
	abstract void countByExampleBefore(F example) throws ServiceException;
	abstract void countByExampleAfter(F example) throws ServiceException;
	abstract void deleteByExampleBefore(F example) throws ServiceException;
	abstract void deleteByExampleAfter(F example) throws ServiceException;
	abstract void insertSelectiveBefore(T record) throws ServiceException;
	abstract void insertSelectiveAfter(T record) throws ServiceException;
	abstract void selectByExampleBefore(F example) throws ServiceException;
	abstract void selectByExampleAfter(F example) throws ServiceException;
	abstract void updateByExampleSelectiveBefore(T record, F example) throws ServiceException;
	abstract void updateByExampleSelectiveAfter(T record, F example) throws ServiceException;
	abstract void updateByExampleBefore(T record, F example) throws ServiceException;
	abstract void updateByExampleAfter(T record, F example) throws ServiceException;
	abstract void deleteByPrimarykeyBefore(Serializable id) throws ServiceException;
	abstract void deleteByPrimarykeyAfter(Serializable id) throws ServiceException;
	abstract void findByPrimarykeyBefore(Serializable id) throws ServiceException;
	abstract void findByPrimarykeyAfter(T o,Serializable id) throws ServiceException;
	abstract void queryForObjectBefore(String statementId, Object parameters) throws ServiceException;
	abstract void queryForObjectAfter(String statementId, Object parameters) throws ServiceException;
	abstract void updateBefore(String statementId, Object parameters) throws ServiceException;
	abstract void updateAfter(String statementId, Object parameters) throws ServiceException;
	abstract void queryForListBefore(String statementId, Object parameters) throws ServiceException;
	abstract void queryForListAfter(String statementId, Object parameters) throws ServiceException;
	
	abstract void selectByExampleAfter(int start, int limit, F example) throws ServiceException;
	abstract void selectByExampletBefore(int start, int limit, F example) throws ServiceException;
	
	public Page<T> selectByExample(int start, int limit, F example) throws ServiceException {
		Page<T> result = null;
		try{
			result = baseDao.selectByExample(start, limit,example);
		}catch(DaoException e){
			throw new ServiceException(e);
		}
		return result;
	}
	
	String insert(T o) throws ServiceException {
		String result = null;
		try {
			result = baseDao.insert(o);
//			result = (String) getMethod("insert", getBeanClass()).invoke(daoObject,o);
			
		} /*catch (SecurityException e) {
			log.error("安全异常");
		} catch (IllegalArgumentException e) {
			log.error("非法参数");
		} catch (IllegalAccessException e) {
			log.error("非法访问");
		} catch (InvocationTargetException e) {
			log.error("调用目标异常");
		}*/ catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	int countByExample(F example) throws ServiceException {
		int result = 0;
		try {
			result = baseDao.countByExample(example);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	int deleteByExample(F example) throws ServiceException {
		int result = 0;
		try {
			result = baseDao.deleteByExample(example);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	String insertSelective(T record) throws ServiceException {
		String result = null;
		try {
			result = baseDao.insertSelective(record);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	List<T> selectByExample(F example) throws ServiceException {
		List<T> result = null;
		try {
			result = baseDao.selectByExample(example);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	int updateByExampleSelective(T record, F example) throws ServiceException {
		int result = 0;
		try {
			result = baseDao.updateByExampleSelective(record, example);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	int updateByExample(T record, F example) throws ServiceException {
		int result = 0;
		try {
			result = baseDao.updateByExample(record, example);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	int deleteByPrimarykey(Serializable id) throws ServiceException {
		int result = 0;
		try {
			result = baseDao.deleteByPrimarykey(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	T findByPrimarykey(Serializable id) throws ServiceException {
		T result = null;
		try {
			result = baseDao.findByPrimarykey(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	T queryForObject(String statementId, Object parameters) throws ServiceException {
		T result = null;
		try {
			result = baseDao.queryForObject(statementId, parameters);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	int update(String statementId, Object parameters) throws ServiceException {
		int result = 0;
		try {
			result = baseDao.update(statementId, parameters);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	List<T> queryForList(String statementId, Object parameters) throws ServiceException {
		List<T> result = null;
		try {
			result = baseDao.queryForList(statementId, parameters);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
}
