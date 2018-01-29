package com.vigalyn.ms.um.service;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface EmailService {
    /**
     * 发送简单邮件
     * @param sendTo 收件人地址
     * @param titel  邮件标题
     * @param content 邮件内容
     */
    void sendSimpleMail(String sendTo, String titel, String content);
    
    /**
     * 发送简单邮件
     * @param sendTo 收件人地址
     * @param titel  邮件标题
     * @param content 邮件内容
     * @param attachments<文件名，附件> 附件列表
     */
    void sendAttachmentsMail(String sendTo, String titel, String content, List<Map<String, File>> attachments);
    
    /**
     * 发送模板邮件
     * @param sendTo 收件人地址
     * @param titel  邮件标题
     * @param content<key, 内容> 邮件内容
     * @param attachments<文件名，附件> 附件列表
     */
    void sendTemplateMail(String sendTo, String titel, Map<String, Object> content, List<Map<String, File>> attachments);
}
