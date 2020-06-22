package com.codemaster.seckil.service;

import com.codemaster.seckil.model.Orders;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IOrderService {

    Orders getOrderByUsernameAndCourseNo(String username, String courseNo);

    Orders saveAndFlush(Orders orders);

    List<Orders> findAllByUsername(String username, Sort sort);

}

