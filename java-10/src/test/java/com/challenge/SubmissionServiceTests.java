package com.challenge;


import com.challenge.entity.Submission;
import com.challenge.service.SubmissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubmissionServiceTests {

    @Autowired
    private SubmissionService submissionService;

    @Test
    public void findHigherScoreByChallengeId() {
        BigDecimal maxScore = submissionService.findHigherScoreByChallengeId(1L);
        assertNotNull(maxScore);
    }

    @Test
    public void findByChallengeIdAndAccelerationIdTest() {
        List<Submission> submissions = submissionService.findByChallengeIdAndAccelerationId(1L, 1L);
        assertNotNull(submissions);
    }
}
