package com.codemaster.seckil;

import com.codemaster.seckil.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Test
    public void test() {
        User user = new User("alex", "0000");
        Assert.assertNotNull(user);

    }
}
