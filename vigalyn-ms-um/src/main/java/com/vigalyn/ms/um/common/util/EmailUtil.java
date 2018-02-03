package com.vigalyn.ms.um.common.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class EmailUtil {

    private final Logger LOG = LoggerFactory.getLogger(EmailUtil.class);

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(6);

    private final AtomicInteger count = new AtomicInteger(1);

    public void start(final JavaMailSender mailSender,final SimpleMailMessage message) {
        scheduledExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (count.get() == 2) {
                        scheduledExecutorService.shutdown();
                        LOG.info("the task is down");
                    }
                    LOG.info("start send email and the index is " + count);
                    mailSender.send(message);
                    LOG.info("send email success");
                }catch (Exception e){
                    LOG.error("send email fail" , e);
                }

            }
        });
    }
    public void startHtml(final JavaMailSender mailSender,final MimeMessage message) {
        scheduledExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (count.get() == 2) {
                        scheduledExecutorService.shutdown();
                        LOG.info("the task is down");
                    }
                    LOG.info("start send email and the index is " + count);
                    mailSender.send(message);
                    LOG.info("send email success");
                }catch (Exception e){
                    LOG.error("send email fail" , e);
                }

            }
        });
    }
}
