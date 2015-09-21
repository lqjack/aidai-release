package com.aidai.dao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.util.Assert;

import com.aidai.dao.DaoException;
import com.aidai.dao.ExampleParams;
import com.aidai.dao.Page;
import com.aidai.model.User;
import com.aidai.utils.GenericsUtils;
import com.aidai.utils.GenericsUtils.CalledMethodInterface;
import com.aidai.utils.GenericsUtils.CalledMethodParam;
import com.aidai.utils.IDGenerator;
import com.aidai.utils.StringUtils;
import com.ibatis.sqlmap.client.SqlMapClient;

@SuppressWarnings("deprecation")
public abstract class AbstractIbatisDao<T, F> extends SqlMapClientDaoSupport {
	private static Log log = LogFactory.getLog(AbstractIbatisDao.class);
	public static final String PRE = "T_";
	public static final String SEPRATE = ".";
	public static final String POSTFIX_INSERT = ".insert";
	public static final String POSTFIX_INSERT_SELECTIVE = ".insertSelective";
	public static final String POSTFIX_DELETE_EXAMPLE = ".deleteByExample";
	public static final String POSTFIX_DELETE_PRIAMARYKEY = ".deleteByPrimaryKey";
	public static final String POSTFIX_SELECT_EXAMPLE = ".selectByExample";
	public static final String POSTFIX_COUNT_EXAMPLE = ".countByExample";
	public static final String POSTFIX_UPDATE_EXAMPLE_SELECTIVE = ".updateByExampleSelective";
	public static final String POSTFIX_UPDATE_EXAMPLE = ".updateByExample";
	@Resource(name = "sqlMapClient")
	private SqlMapClient sqlMapClient;

	@PostConstruct
	public void initSqlMapClient() {
		super.setSqlMapClient(sqlMapClient);
	}
	/**
	 * 根据ID获取对象
	 * @throws DaoException
	 */
	@SuppressWarnings({ "unchecked" })
	protected <B> T get(Class<B> entityClass, Serializable id) throws DaoException {
		try {
			return (T) getSqlMapClientTemplate().queryForObject(
					getStatementId(getGenerateParamClass(0), AbstractIbatisDao.POSTFIX_SELECT_EXAMPLE),
					getExampleByPrimaryKey(id));
		} catch (DataAccessException e) {
			log.error("code:dao,msg:数据库访问异常");
			throw new DaoException("dao", "数据库访问异常");
		}
	}
	@SuppressWarnings("rawtypes")
	private Class getGenerateParamClass(int i) {
		try{
			return GenericsUtils.getGenerateParamClass(this.getClass(), i);
		}catch(Exception e){
			log.error(e);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	private T setInnerId(T o, String generateValue) throws DaoException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		return (T) GenericsUtils.setParam(getGenerateParamClass(0), o, "setId",String.class,generateValue);
	}
	
	private T InitCreateDateTimeAndStatus(T o) throws DaoException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		List<CalledMethodInterface> params = new ArrayList<CalledMethodInterface>();
		Date date = new Date();
		params.add(new CalledMethodParam("setCreateDatetime", Date.class, date ));
		params.add(new CalledMethodParam("setModifyDatetime", Date.class, date ));
		if(o instanceof User){
			params.add(new CalledMethodParam("setStatus", Integer.class, 1 ));
		}else{
			params.add(new CalledMethodParam("setStatus", String.class, "1" ));
		}
		return GenericsUtils.setParam(getGenerateParamClass(0), o, params);
	}
	
	@SuppressWarnings("unchecked")
	private T initModifyDateTime(T o) {
		return (T) GenericsUtils.setParam(getGenerateParamClass(0), o, "setModifyDatetime",Date.class,new Date());
	}
	
	/**
	 * 新增对象
	 * @throws DaoException
	 */
	protected String insert(T o) throws DaoException {
		String exception = null;
		try {
			String generateValue = IDGenerator.getInstance().generate();
			getSqlMapClientTemplate().insert(getStatementId(o.getClass(), AbstractIbatisDao.POSTFIX_INSERT),
					InitCreateDateTimeAndStatus(setInnerId(o, generateValue)));
			return generateValue;
		} catch (Exception e) {
			exception = "code : dao-205,msg: 没有该方法";
			log.error(exception);
			throw new DaoException("dao-205", "没有该方法");
		}
	}
	/*
	 * protected int update(G o) throws DaoException { try { return
	 * (Integer)getSqlMapClientTemplate().update( getStatementId(getGenerateParamClass(0),
	 * AbstractIbatisDao.POSTFIX_UPDATE_EXAMPLE), o); } catch (DataAccessException e) {
	 * e.printStackTrace(); log.error("数据库更新异常"); throw new DaoException("dao", "数据库更新异常"); } }
	 */
	/*
	 * protected int delete(T o) throws DaoException { try { return (Integer)
	 * getSqlMapClientTemplate() .delete(getStatementId(o.getClass(),
	 * AbstractIbatisDao.POSTFIX_DELETE_PRIAMARYKEY), o); } catch (DataAccessException e) {
	 * log.error(""); throw new DaoException("dao", "数据库删除异常"); } }
	 */
	private Object getExampleByPrimaryKey(Serializable id) throws DaoException {
		Object obj = GenericsUtils.getInstance(getGenerateParamClass(1));
		CalledMethodInterface methodInterface = new GenericsUtils.CalledMethodNoneparam("createCriteria");
		Object criteria = GenericsUtils.getParam(getGenerateParamClass(1), obj, methodInterface);
		
		GenericsUtils.setParam(criteria.getClass(), criteria, "andIdEqualTo",String.class, id);
		return obj;
	}
	/**
	 * 根据ID删除对象
	 */
	protected <B> int deleteByPrimarykey(Class<B> entityClass, Serializable id) throws DaoException {
		try {
			return getSqlMapClientTemplate().delete(
					getStatementId(getGenerateParamClass(0), AbstractIbatisDao.POSTFIX_DELETE_EXAMPLE),
					getExampleByPrimaryKey(id));
		} catch (DataAccessException e) {
			log.error("code:dao,msg:数据库访问异常");
			throw new DaoException("dao", "数据库删除异常");
		}
	}
	@SuppressWarnings("rawtypes")
	private String getStatementId(Class entityClass, String suffix) {
		String className = entityClass.getName();
		String shortName = className.replace(entityClass.getPackage().getName() + ".", "");
		return PRE + StringUtils.upperCase(shortName) + suffix;
	}
	
	protected int countByExample(F example) throws DaoException {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				getStatementId(getGenerateParamClass(0), AbstractIbatisDao.POSTFIX_COUNT_EXAMPLE), example);
	}
	protected int deleteByExample(F example) throws DaoException {
		return getSqlMapClientTemplate()
				.delete(getStatementId(getGenerateParamClass(0), AbstractIbatisDao.POSTFIX_DELETE_EXAMPLE), example);
	}
	@SuppressWarnings("unchecked")
	protected List<T> selectByExample(F example) throws DaoException {
		return getSqlMapClientTemplate().queryForList(
				getStatementId(getGenerateParamClass(0), AbstractIbatisDao.POSTFIX_SELECT_EXAMPLE), example);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ExampleParams<T, F> getExampleParams(T record, F example) throws DaoException {
		ExampleParams<T, F> params = new ExampleParams<T, F>(record, example);
		params.setRecord(record);
		
		params.setOrderByClause((String)GenericsUtils.getParam(getGenerateParamClass(1), example, new GenericsUtils.CalledMethodNoneparam("getOrderByClause")));
		params.setDistinct((Boolean)GenericsUtils.getParam(getGenerateParamClass(1), example, new GenericsUtils.CalledMethodNoneparam("isDistinct")));
		params.setOredCriteria((List)GenericsUtils.getParam(getGenerateParamClass(1), example, new GenericsUtils.CalledMethodNoneparam("getOredCriteria")));
		params.setMysqlOffset((Integer) GenericsUtils.getParam(getGenerateParamClass(1), example, new GenericsUtils.CalledMethodNoneparam("getMysqlOffset")));
		params.setMysqlLength((Integer) GenericsUtils.getParam(getGenerateParamClass(1), example, new GenericsUtils.CalledMethodNoneparam("getMysqlLength")));
		
		return params;
	}
	protected int updateByExample(T record, F example) throws DaoException {
		initModifyDateTime(record);
		return getSqlMapClientTemplate().update(
				getStatementId(record.getClass(), AbstractIbatisDao.POSTFIX_UPDATE_EXAMPLE),
				getExampleParams(record, example));
	}
	protected int updateByExampleSelective(T record, F example) throws DaoException {
		initModifyDateTime(record);
		return getSqlMapClientTemplate().update(
				getStatementId(record.getClass(), AbstractIbatisDao.POSTFIX_UPDATE_EXAMPLE_SELECTIVE),
				getExampleParams(record, example));
	}
	
	@SuppressWarnings({ "unchecked" })
	protected <B> T queryForObject(Class<B> entityClass, String statementId, Object parameters) throws DaoException{
		return (T) getSqlMapClientTemplate().queryForObject(getStatementId(entityClass, statementId), parameters);
	}
	@SuppressWarnings({ "unchecked" })
	protected <B> List<T> queryForList(Class<B> entityClass, String statementId, Object parameters)
			throws DaoException {
		try {
			return getSqlMapClientTemplate().queryForList(getStatementId(entityClass, statementId), parameters);
		} catch (DataAccessException e) {
			log.error("");
			throw new DaoException("dao", "数据库查询异常");
		}
	}
	protected int update(String statementId, Object parameters) throws DaoException {
		try {
			return (Integer) getSqlMapClientTemplate().update(statementId, parameters);
		} catch (DataAccessException e) {
			log.error("");
			throw new DaoException("dao", "数据库更新异常");
		}
	}
	@SuppressWarnings({ "rawtypes" })
	protected int update(Class entityClass, String statementId, Object parameters) throws DaoException {
		try {
			return (Integer) getSqlMapClientTemplate().update(getStatementId(entityClass, statementId), parameters);
		} catch (DataAccessException e) {
			log.error("");
			throw new DaoException("dao", "数据库更新异常");
		}
	}
	public Page<T> selectByExample(int start, int limit, F example) throws DaoException {
		Assert.isTrue(start >= 0, "pageNo should start from 0");
		// 计算总数
		Integer totalCount = this.countByExample(example);
		// 如果没有数据则返回Empty Page
		Assert.notNull(totalCount, "totalCount Error");
		if (totalCount.intValue() == 0) {
			return new Page<T>();
		}
		List<T> list;
		int totalPageCount = 0;
		int startIndex = 0;
		// 如果pageSize小于0,则返回所有数捄1177,等同于getAll
		if (limit > 0) {
			// 计算页数
			totalPageCount = (totalCount / limit);
			totalPageCount += ((totalCount % limit) > 0) ? 1 : 0;
			// 计算skip数量
			if (totalCount > start) {
				startIndex = start;
			} else {
				startIndex = (totalPageCount - 1) * limit;
			}
		}
		List<CalledMethodInterface> params = new ArrayList<GenericsUtils.CalledMethodInterface>();
		params.add(new CalledMethodParam("setMysqlOffset", Integer.class, startIndex));
		params.add(new CalledMethodParam("setMysqlLength", Integer.class, limit));
		GenericsUtils.setParam(getGenerateParamClass(1), example, params);
		
		list = selectByExample(example);
		
		return new Page<T>(totalCount,startIndex, limit, list);
	}
}
