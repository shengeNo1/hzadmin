package me.shengeNo1.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName LimitAspect.java
 * @Description TODO
 * @createTime 2021年01月02日 20:01:00
 */

public class LimitAspect {

    private final RedisTemplate<Object,Object> redisTemplate;
    private static final Logger logger = LoggerFactory.getLogger(LimitAspect.class);

    public LimitAspect(RedisTemplate<Object,Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
