package com.aidai.dao;

import java.util.List;

public interface IbatisGenericDao {

     public <T> T getRecord(String sqlID, Object object) throws Exception;

     public <T> List<T> getRecordList(String sqlID, Object object) throws Exception;
     
     public <T> List<T> getRecordList(String sqlID, Object object, int offset, int limit) throws Exception;

     public int insertRecord(String sqlID, Object object) throws Exception;

     public int updateRecord(String sqlID, Object object) throws Exception;

     public int deleteRecord(String sqlID, Object object) throws Exception;
     
     public void batchInsert(final String sqlID, @SuppressWarnings("rawtypes") final List objects) throws Exception;
}
