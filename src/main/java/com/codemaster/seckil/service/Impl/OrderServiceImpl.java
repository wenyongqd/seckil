package com.codemaster.seckil.service.Impl;

import com.codemaster.seckil.model.Orders;
import com.codemaster.seckil.repository.OrderRepository;
import com.codemaster.seckil.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Orders getOrderByUsernameAndCourseNo(String username, String courseNo) {
        return orderRepository.findByUsernameAndCourseNo(username, courseNo);
    }

    @Override
    public Orders saveAndFlush(Orders orders) {
        return orderRepository.saveAndFlush(orders);
    }

    @Override
    public List<Orders> findAllByUsername(String username, Sort sort) {
        return orderRepository.findByUsername(username, sort);
    }

}
