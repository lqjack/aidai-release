package com.aidai.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, F> {
	/**
	 * @Title: insert
	 * @Description:新增对象到数据库
	 * @param o 对象实体
	 * @return
	 * @throws DaoException
	 * @return: String
	 */
	String insert(T o) throws DaoException;
	/**
	 * @Title: countByExample
	 * @Description: 查询条件匹配的数量
	 * @param example
	 * @return
	 * @throws DaoException
	 * @return: int
	 */
	int countByExample(F example) throws DaoException;
	/**
	 * @Title: deleteByExample
	 * @Description: 删除条件匹配的对象
	 * @param example
	 * @return
	 * @throws DaoException
	 * @return: int
	 */
	int deleteByExample(F example) throws DaoException;
	/**
	 * @Title: insertSelective
	 * @Description: 插入对象
	 * @param record
	 * @return
	 * @throws DaoException
	 * @return: String
	 */
	String insertSelective(T record) throws DaoException;
	/**
	 * @Title: selectByExample
	 * @Description: 查询对象
	 * @param example
	 * @return
	 * @throws DaoException
	 * @return: List<T>
	 */
	List<T> selectByExample(F example) throws DaoException;
	/**
	 * @Title: updateByExampleSelective
	 * @Description: 更新对象
	 * @param record
	 * @param example
	 * @return
	 * @throws DaoException
	 * @return: int
	 */
	int updateByExampleSelective(T record, F example) throws DaoException;
	/**
	 * @Title: updateByExample
	 * @Description: 更新对象
	 * @param record
	 * @param example
	 * @return
	 * @throws DaoException
	 * @return: int
	 */
	int updateByExample(T record, F example) throws DaoException;
	/**
	 * 根据主键删除对象
	 * @param id 主键值
	 */
	int deleteByPrimarykey(Serializable id) throws DaoException;
	/**
	 * 根据主键查找对象
	 * @param id 主键值
	 * @return 对象实体
	 */
	T findByPrimarykey(Serializable id) throws DaoException;
	/**
	 * @Title: queryForObject
	 * @Description: 自定义参数查询
	 * @param statementId 若数据库中的 ID为T_USER.test，需要填入.test
	 * @param parameters 填入的参数
	 * @return
	 * @throws DaoException
	 * @return: T
	 */
	T queryForObject(String statementId, Object parameters) throws DaoException;
	/**
	 * @Title: queryForList
	 * @Description: 自定义列表查询
	 * @param statementId
	 * @param parameters
	 * @return
	 * @throws DaoException
	 * @return: List<T>
	 */
	List<T> queryForList(String statementId, Object parameters) throws DaoException;
	/**
	 * 
	 * @Title: update 
	 * @Description: 自定义更新
	 * @param statementId
	 * @param parameters
	 * @return
	 * @throws DaoException
	 * @return: int
	 */
	int update(String statementId, Object parameters) throws DaoException;
	/**
	 * @Title: queryForList
	 * @Description: 分页查询
	 * @param statementId
	 * @param parameters
	 * @return
	 * @throws DaoException
	 * @return: List<T>
	 */
	Page<T> selectByExample(int start, int limit, F example)throws DaoException;
}
