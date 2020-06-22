package com.codemaster.seckil.controller.api;

import com.codemaster.seckil.base.controller.BaseApiController;
import com.codemaster.seckil.base.result.Result;
import com.codemaster.seckil.model.Orders;
import com.codemaster.seckil.model.User;
import com.codemaster.seckil.service.IOrderService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderAPIController extends BaseApiController {


    @Autowired
    public IOrderService orderService;


    @RequestMapping(value="orderList",method= RequestMethod.GET)
    public Result<List<Orders>> orderList(User user){
        return Result.success(orderService.findAllByUsername(user.getUsername(),Sort.by(Sort.Direction.DESC,"createDate")));
    }
}
