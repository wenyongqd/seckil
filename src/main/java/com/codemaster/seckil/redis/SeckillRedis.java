package com.codemaster.seckil.redis;

import com.codemaster.seckil.model.Orders;
import org.springframework.stereotype.Repository;

@Repository
public class SeckillRedis extends BaseRedis<Orders>{
    private static final String REDIS_KEY = "com.codemaster.seckil.redis.SeckillRedis";

    @Override
    protected String getRedisKey() {
        return REDIS_KEY;
    }

}
