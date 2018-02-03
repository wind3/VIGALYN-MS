package com.vigalyn.ms.www.service.impl;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.vigalyn.ms.www.domain.NewsMain;
import com.vigalyn.ms.www.service.NewsService;
@Service
public class NewsServiceImpl extends BaseServiceImpl<NewsMain> implements NewsService<NewsMain> {
    private final static Logger LOG = LoggerFactory.getLogger(NewsServiceImpl.class);

    public static final int DoTime = 5000;
    /**
     * 测试异步方法，带返回值的
     * @return
     * @throws Exception
     */
    @Async
    public Future<Long> subByAsync() throws Exception {
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);
        long end = System.currentTimeMillis();
        sum = end - start;
        LOG.info("\t 完成任务一");
        return new AsyncResult<>(sum);
}
}
