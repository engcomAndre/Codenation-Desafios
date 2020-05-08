package com.challenge;


import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.service.AccelerationService;
import com.challenge.service.CandidateService;
import com.challenge.service.CompanyService;
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
public class CandidateServiceTests {

    @Autowired
    private AccelerationService accelerationService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CandidateService candidateService;

    @Test
    public void findByCandidateIdTest() {
        CandidateId candidateId = new CandidateId(
                userService.findById(1L).orElse(null),
                accelerationService.findById(1L).orElse(null),
                companyService.findById(2L).orElse(null)
        );
        Candidate candidate = candidateService.findById(candidateId).orElse(null);
        assertNotNull(candidate);
    }

    @Test
    public void findByCandidateIdParametersTest() {
        Candidate candidate = candidateService.findById(1L, 2L, 1L).orElse(null);
        assertNotNull(candidate);
    }

    @Test
    public void findByCompanyIdTest() {
        List<Candidate> candidate = candidateService.findByCompanyId(2L);
        assertNotNull(candidate);
    }

    @Test
    public void findByAccelerationIdTest() {
        List<Candidate> candidate = candidateService.findByAccelerationId(1L);
        assertNotNull(candidate);
    }
}
