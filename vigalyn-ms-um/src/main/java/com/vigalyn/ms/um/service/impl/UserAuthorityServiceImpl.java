package com.vigalyn.ms.um.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vigalyn.ms.um.domain.UserAuthority;
import com.vigalyn.ms.um.service.UserAuthorityService;

@Service
public class UserAuthorityServiceImpl implements UserAuthorityService {

    @Override
    public void batchUpdate(List<UserAuthority> listEntity) {
        // TODO Auto-generated method stub

    }

    @Override
    public int insertSelective(UserAuthority entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(UserAuthority entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public UserAuthority selectOneByPrimaryKey(UserAuthority entity) {
        UserAuthority resData = new UserAuthority();
        resData.setUserId("zengwj");
        return resData;
    }

    @Override
    public List<UserAuthority> selectList(UserAuthority entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateByPrimaryKey(UserAuthority entity) {
        // TODO Auto-generated method stub
        
    }

}
