package com.vigalyn.ms.um.controller;

import java.text.DateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigalyn.ms.um.domain.UserAuthority;
import com.vigalyn.ms.um.dto.ResultDTO;
import com.vigalyn.ms.um.service.EmailService;
import com.vigalyn.ms.um.service.UserAuthorityService;

@RestController
@RequestMapping(value = "/userAuthority", produces= {"application/json; charset=UTF-8"})
public class UserAuthorityController {

    private static final Logger LOG = LoggerFactory.getLogger(UserAuthorityController.class);
    @Autowired
    private UserAuthorityService userAuthorityService;
    @Autowired
    EmailService emailService;
    @GetMapping("/{userId}")
    public ResultDTO<UserAuthority> selectOne(@PathVariable String userId){
        LOG.info("param userId = " + userId);
        ResultDTO<UserAuthority> resultDTO = null;
        UserAuthority entity = new UserAuthority();        
        UserAuthority resData = userAuthorityService.selectOneByPrimaryKey(entity);
        resultDTO = new ResultDTO<UserAuthority>(resData);
        Date curr = new Date();
        DateFormat format = DateFormat.getDateInstance();
        LOG.info(format.format(curr));
        emailService.sendSimpleMail("wind3at048@163.com", "测试邮件发送", "测试内容1");
        
        Date after = new Date();
        LOG.info(format.format(after));
        return resultDTO;
    }
}
