package com.codemaster.seckil;

import com.codemaster.seckil.VO.UserVO;
import com.codemaster.seckil.model.User;
import com.codemaster.seckil.redis.UserRedis;
import com.codemaster.seckil.repository.UserRepository;
import com.codemaster.seckil.service.UserService;
import com.codemaster.seckil.util.MD5Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Autowired
    public UserRedis userRedis;

    @Test
    public void test() {
        User user = new User("alex2018","0000");
        Assert.assertNotNull(userService.regist(user));
    }

    @Test
    public void restGetUser() {
        Assert.assertNotNull(userService.getUser("Alex1999"));
    }

    @Test
    public void testPassword() {
        UserVO user = userService.getUser("Alex1999");
        String password = MD5Util.inputToDb("123456", user.getDbflag());
        Assert.assertEquals(password, user.getPassword());
    }

    @Test
    public void testRedis(){
        User user = new User("Alex1999", "123456");
        userRedis.put(user.getUsername(), user, -1);
    }
}
