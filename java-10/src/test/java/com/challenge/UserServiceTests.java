package com.challenge;


import com.challenge.entity.User;
import com.challenge.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void findByIdTest() {
        User user = userService.findById(1L).orElse(null);
        assertNotNull(user);
    }

    @Test
    public void findByAccelerationNameTest() {
        List<User> users = userService.findByAccelerationName("NAME_ACCELERATION_A");
        assertNotNull(users);
    }

    @Test
    public void findByCompanyIdTest() {
        List<User> users = userService.findByCompanyId(2L);
        assertNotNull(users);
    }


}
