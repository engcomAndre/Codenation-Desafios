package com.challenge;

import com.challenge.entity.Acceleration;
import com.challenge.service.AccelerationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccelerationServiceTest {

    @Autowired
    private AccelerationService accelerationService;

    @Test
    public void findByIdTest() {
        Acceleration acceleration = accelerationService.findById(1L).orElse(null);
        assertNotNull(acceleration);
        assertEquals(1L, acceleration.getId().longValue());
    }

    @Test
    public void findByNameTest() {
        Acceleration acceleration = accelerationService.findByName("NAME_ACCELERATION_A").orElse(null);
        assertNotNull(acceleration);
        assertEquals("NAME_ACCELERATION_A", acceleration.getName());
    }

    @Test
    public void findByCompanyIdTest(){
        List<Acceleration> accelerations = accelerationService.findByCompanyId(1L);
        assertNotNull(accelerations);
    }
}