package com.vigalyn.ms.www.service;

import java.util.List;

public interface BaseService<T> {

    int insertSelective(T entity);
    
    int deleteByPrimaryKey(T entity);
    
    T selectOneByPrimaryKey(T entity);
    
    List<T> selectList(T entity);
    
    void updateByPrimaryKey(T entity);
    
    void batchUpdate(List<T> listEntity);
        
}
