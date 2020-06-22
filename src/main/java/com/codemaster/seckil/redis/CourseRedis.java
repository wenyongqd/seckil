package com.codemaster.seckil.redis;

import com.codemaster.seckil.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRedis extends BaseRedis<Course>{

    private static final String REDIS_KEY = "com.codemaster.seckil.redis.CourseRedis";

    @Override
    protected String getRedisKey() {
        return REDIS_KEY;
    }

}
