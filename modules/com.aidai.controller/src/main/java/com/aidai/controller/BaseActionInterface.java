package com.aidai.controller;

public interface BaseActionInterface {
	/**
	 * action的初始化方法
	 * @return
	 */
	String init();
	/**
	 * action的新增方法
	 * @return
	 */
	String add();
	/**
	 * action的修改方法
	 * @return
	 */
	
	String modify();
	/**
	 * action的删除方法
	 * @return
	 */
	String del();
	/**
	 * action的查询方法
	 * @return
	 */
	String list();
}
