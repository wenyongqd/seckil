package com.codemaster.seckil.kafka;

import com.codemaster.seckil.model.Course;
import com.codemaster.seckil.model.Orders;
import com.codemaster.seckil.model.User;
import com.codemaster.seckil.service.ICourseService;
import com.codemaster.seckil.service.IOrderService;
import com.codemaster.seckil.service.ISeckillService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    public ICourseService courseService;

    @Autowired
    public IOrderService orderService;

    @Autowired
    public ISeckillService seckillService;

    @KafkaListener(id="seconds-kill", topics = "test", groupId = "seconds-kill")
    public void listener(ConsumerRecord<?, ?> record) throws InterruptedException {

        new Thread().sleep(2000);
        System.out.println("接收消息：" + record.value().toString());
        String[] messages = record.value().toString().split(",");
        String courseNo  = messages[0];
        String username  = messages[1];

        Course course = courseService.findCourseByCourseNo(courseNo);
        int stock = course.getStockQuantity();
        if(stock <= 0){
            return ;
        }
        //判断是否已经购买
        Orders order = orderService.getOrderByUsernameAndCourseNo(username, courseNo);
        if(order != null){
            return ;
        }
        //减库存 下订单
        User user = new User();
        user.setUsername(username);
        seckillService.seckill(user, course);
    }
}
