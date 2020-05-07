package com.challenge;

import com.challenge.entity.User;
import com.challenge.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringChallengeApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {

    }

    @Test
    public void findByIdTest() {
        User user = userService.findById(1L).orElse(null);
        assertNotNull(user);
    }


}
