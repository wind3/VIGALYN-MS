package com.vigalyn.ms.www.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigalyn.ms.www.common.exception.ServiceException;
import com.vigalyn.ms.www.common.util.Pair;
import com.vigalyn.ms.www.dto.NewsDTO;
import com.vigalyn.ms.www.dto.ResultDTO;
import com.vigalyn.ms.www.service.EmailService;

import io.swagger.annotations.Api;

@Api("新闻中心接口")
@RestController
@RequestMapping(value="/news",produces= {"application/json;charset=UTF-8"})
public class NewsController {
    private static final Logger LOG = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    EmailService emailService;
    
    @GetMapping("/list")
    public ResultDTO<NewsDTO> getListNewsAndContent() {
        ResultDTO<NewsDTO> resultDTO = null;
     //   emailService.sendSimpleMail("wind3at048@126.com", "vigalyn项目测试", "vigalyn项目测试");
        Map<String,Object> param = new HashMap<>();
        param.put("userName", "曾维嘉");
        param.put("content", "这是一个带附件的邮件！");
        Pair<String, File> pair = Pair.create("fileName.jpg", new File("C:\\Users\\wind3\\Pictures\\Saved Pictures\\timg.jpg"));
        List<Pair<String, File>> attachments = new ArrayList<>();
        attachments.add(pair);
        try {
            emailService.sendHtmlMailWithAttachments("wind3at048@126.com", "vigalyn项目测试", 
                    "email/systemEmailTemplate.html", param, attachments);
        } catch (ServiceException e) {
            LOG.error(e.getMessage());
            return new ResultDTO<NewsDTO>(e.getErrorCode(),e.getMessage());
        }
        resultDTO = new ResultDTO<NewsDTO>();
        return resultDTO;
    }
    
    @GetMapping("/news/{newsId}")
    public ResultDTO<String> getNewsContent(@PathVariable String newsId) {
        ResultDTO<String> resultDTO = null;
        LOG.info("param newsId = " + newsId);
        resultDTO = new ResultDTO<String>(newsId);
        return resultDTO;
    }
}
