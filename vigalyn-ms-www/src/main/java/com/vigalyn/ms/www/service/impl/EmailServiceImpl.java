package com.vigalyn.ms.www.service.impl;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.vigalyn.ms.www.common.constant.ErrorCodeAndMsg;
import com.vigalyn.ms.www.common.exception.ServiceException;
import com.vigalyn.ms.www.common.util.Pair;
import com.vigalyn.ms.www.service.EmailService;

import freemarker.template.Template;

@Async
@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private FreeMarkerConfigurer  freeMarkerConfigurer;   
    @Value("${spring.mail.username}")
    private String from;
    
    
    /**
     * 发送纯文本邮件
     * @param sendTo
     * @param titel
     * @param content
     */
    @Override
    public void sendSimpleMail(String sendTo, String titel, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(sendTo);
        message.setSubject(titel);
        message.setText(content);
        javaMailSender.send(message);
    }
    
    /**
     * 发送HTML模板邮件
     * @param sendTo
     * @param subject
     * @param param
     * @throws ServiceException
     */
    
    @Override
    public void sendHtmlMail(String sendTo, String subject, String template,Map<String,Object> param) throws ServiceException {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(sendTo);
            helper.setSubject(subject);
            Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(template,Locale.getDefault(),"UTF-8");
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, param);
            helper.setText(content, true);
            javaMailSender.send(message);
            LOG.info("html邮件发送成功");
        } catch (MessagingException e) {
            LOG.error("发送html邮件时发生异常！", e);
            throw new ServiceException(ErrorCodeAndMsg.BUILD_EMAIL_ERR.getErrCode(),
                    ErrorCodeAndMsg.BUILD_EMAIL_ERR.getErrMsg());
        }catch (Exception e) {
            LOG.error("发送html邮件时发生异常！", e);
            throw new ServiceException(ErrorCodeAndMsg.SEND_EMAIL_ERR.getErrCode(),
                    ErrorCodeAndMsg.SEND_EMAIL_ERR.getErrMsg());
        }
    }
    
    /**
     * 发送带有附件的HTML模板邮件
     * @param sendTo
     * @param subject
     * @param content
     * @param attachments
     * @throws ServiceException
     */
    
    @Override
    public void sendHtmlMailWithAttachments(String sendTo, String subject,String template, Map<String,Object> param, List<Pair<String, File>> attachments) throws ServiceException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(sendTo);
            helper.setSubject(subject);
            Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(template,Locale.getDefault(),"UTF-8");
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, param);
            helper.setText(content, true);
            for (Pair<String, File> pair : attachments) {
                helper.addAttachment(pair.getLeft(), new FileSystemResource(pair.getRight()));
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        javaMailSender.send(mimeMessage);
    }
    
    /**
     * 发送内嵌图片的HTML模板邮件
     * @param sendTo
     * @param subject
     * @param template
     * @param param
     * @param inlines
     * @throws ServiceException
     */
    @Override
    public void sendHtmlMailWithInlines(String sendTo, String subject,String template,Map<String,Object> param,List<Pair<String, File>> inlines) throws ServiceException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(sendTo);
            helper.setSubject(subject);           
            Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(template,Locale.getDefault(),"UTF-8");
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, param);
            helper.setText(content, true); 
            for (Pair<String, File> pair : inlines) {
                helper.addInline(pair.getLeft(), new FileSystemResource(pair.getRight()));
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        javaMailSender.send(mimeMessage);
    }
}
