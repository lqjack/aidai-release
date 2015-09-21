package com.aidai.dao;

import java.util.List;

import com.aidai.model.UserExample.Criteria;

public class ExampleParams<T,F> {
	private T record;
	
	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;
	

    public ExampleParams(T record, F example) {
    	this.record = record;
    	init(example);
    }

    private void init(F example) {
	}

	public T getRecord() {
        return record;
    }

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void setOredCriteria(List<Criteria> oredCriteria) {
		this.oredCriteria = oredCriteria;
	}

	public Integer getMysqlOffset() {
		return mysqlOffset;
	}

	public void setMysqlOffset(Integer mysqlOffset) {
		this.mysqlOffset = mysqlOffset;
	}

	public Integer getMysqlLength() {
		return mysqlLength;
	}

	public void setMysqlLength(Integer mysqlLength) {
		this.mysqlLength = mysqlLength;
	}

	public void setRecord(T record) {
		this.record = record;
	}
	
	
}
