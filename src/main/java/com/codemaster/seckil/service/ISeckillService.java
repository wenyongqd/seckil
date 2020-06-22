package com.codemaster.seckil.service;

import com.codemaster.seckil.base.result.Result;
import com.codemaster.seckil.model.Course;
import com.codemaster.seckil.model.Orders;
import com.codemaster.seckil.model.User;

import javax.servlet.http.HttpServletRequest;

public interface ISeckillService {

    Result<Orders> seckillFlow(User user, String courseNo);

    void cacheAllCourse();

    public Orders seckill(User user, Course course);

    Result<Orders> seckillResult(User user, String courseNo);

    String getPath(User user, String courseNo);

    Result<Orders> seckillFlow(User user, String courseNo, String path);

    Result<Orders> seckillFlow(User user, String courseNo, String path, HttpServletRequest request);

}
