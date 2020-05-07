package com.challenge;


import com.challenge.entity.Company;
import com.challenge.service.CompanyService;
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
public class CompanyServiceTests {

    @Autowired
    private CompanyService companyService;

    @Test
    public void findByIdTest() {
        Company company = companyService.findById(1L).orElse(null);
        assertNotNull(company);
        assertEquals(1L, company.getId().longValue());
    }

    @Test
    public void findByAccelerationIdTest() {
        List<Company> companies = companyService.findByAccelerationId(1L);
        assertNotNull(companies);
    }

    @Test
    public void findByUserIdTest() {
        List<Company> companies = companyService.findByUserId(1L);
        assertNotNull(companies);
    }

}
