package com.challenge;


import com.challenge.entity.Challenge;
import com.challenge.service.ChallengeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeServiceTests {

    @Autowired
    private ChallengeService challengeService;

    @Test
    public void findByAccelerationIdAndUserIdTests() {
        List<Challenge> challenges = challengeService.findByAccelerationIdAndUserId(1L, 1L);
        assertNotNull(challenges);
    }
}
