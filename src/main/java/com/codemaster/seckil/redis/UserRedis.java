package com.codemaster.seckil.redis;

import com.codemaster.seckil.model.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class UserRedis extends BaseRedis<User>{

    private static final String REDIS_KEY = "com.codemaster.seckil.redis.UserRedis";

    @Override
    protected String getRedisKey() {
        return REDIS_KEY;
    }
}

