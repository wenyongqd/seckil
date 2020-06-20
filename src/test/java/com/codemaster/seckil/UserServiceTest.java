package com.codemaster.seckil;

import com.codemaster.seckil.model.User;
import com.codemaster.seckil.repository.UserRepository;
import com.codemaster.seckil.service.UserService;
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

    @Test
    public void test() {
        User user = new User("alex2018","0000");
        Assert.assertNotNull(userService.regist(user));

    }
}
