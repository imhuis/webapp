package com.imhui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class RedisTest {
    /**
     * https://juejin.cn/post/6844903954778701832
     */

    private final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        logger.info("redisConnectionFactory: {}", redisTemplate.getConnectionFactory().getConnection());

        List<RedisClientInfo> redisClientInfos = redisTemplate.getClientList();
        logger.info("redisClientInfos: \n{}", redisClientInfos);
    }
}
