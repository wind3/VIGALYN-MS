package com.vigalyn.ms.www.service.impl;

import java.io.Serializable;
import java.util.List;

import com.vigalyn.ms.www.service.BaseService;

public class BaseServiceImpl<T extends Serializable> implements BaseService<T> {

    @Override
    public int insertSelective(T entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(T entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public T selectOneByPrimaryKey(T entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> selectList(T entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateByPrimaryKey(T entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void batchUpdate(List<T> listEntity) {
        // TODO Auto-generated method stub
        
    }

}
