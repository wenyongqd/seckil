package com.codemaster.seckil.controller.api;

import com.codemaster.seckil.base.controller.BaseApiController;
import com.codemaster.seckil.base.result.Result;
import com.codemaster.seckil.model.Orders;
import com.codemaster.seckil.model.User;
import com.codemaster.seckil.service.ISeckillService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class SeckillAPIController extends BaseApiController implements InitializingBean {

    @Autowired
    public ISeckillService seckillService;

    @Override
    public void afterPropertiesSet() throws Exception {
        seckillService.cacheAllCourse();
    }

    @RequestMapping(value="{path}/seckill/{courseNo}",method= RequestMethod.GET)
    public Result<Orders> seckill(User user, @PathVariable String courseNo, @PathVariable String path, HttpServletRequest request){
        if(user == null){
            System.out.println("失败失败失败失败失败失败失败失败失败");
            return Result.failure();
        }
        System.out.println("========================");
        return seckillService.seckillFlow(user, courseNo, path, request);
    }

    @RequestMapping(value="seckill/{courseNo}",method=RequestMethod.GET)
    public Result<Orders> seckill(User user, @PathVariable String courseNo){
        if(user == null){
            return Result.failure();
        }
        return seckillService.seckillFlow(user, courseNo);
    }

    @RequestMapping(value="seckillResult/{courseNo}",method=RequestMethod.GET)
    public Result<Orders> seckillResult(User user, @PathVariable String courseNo){
        if(user == null){
            return Result.failure();
        }
        return seckillService.seckillResult(user, courseNo);
    }

    @RequestMapping(value="getPath/{courseNo}",method=RequestMethod.GET)
    public String getPath(User user, @PathVariable String courseNo){
        if(user == null){
            System.out.println("空空空空空空空空空空空空空空空空空空空空空空");
        }
        return seckillService.getPath(user, courseNo);
    }
}
