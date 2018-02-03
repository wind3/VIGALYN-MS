package com.vigalyn.ms.www.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.vigalyn.ms.www.common.exception.ServiceException;
import com.vigalyn.ms.www.common.util.Pair;

public interface EmailService {
    /**
     * 发送纯文本邮件
     * @param sendTo
     * @param titel
     * @param content
     */
    void sendSimpleMail(String sendTo, String titel, String content);
    
    /**
     * 发送HTML模板邮件
     * @param sendTo
     * @param subject
     * @param param
     * @throws ServiceException
     */
    void sendHtmlMail(String sendTo, String subject, 
            String template,Map<String,Object> param) throws ServiceException ;
    
    /**
     * 发送带有附件的HTML模板邮件
     * @param sendTo
     * @param subject
     * @param content
     * @param attachments
     * @throws ServiceException
     */
    void sendHtmlMailWithAttachments(String sendTo, String subject,String template, 
            Map<String,Object> param, List<Pair<String, File>> attachments) throws ServiceException ;
    
    /**
     * 发送内嵌图片的HTML模板邮件
     * @param sendTo
     * @param subject
     * @param template
     * @param param
     * @param inlines
     * @throws ServiceException
     */    
    void sendHtmlMailWithInlines(String sendTo, String subject,String template,
            Map<String,Object> param,List<Pair<String, File>> inlines) throws ServiceException ;



}
