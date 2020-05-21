package com.challenge.endpoints.impl;

import com.challenge.endpoints.interfaces.CompanyControllerInterface;
import com.challenge.entity.Company;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/company")
public class CompanyController implements CompanyControllerInterface {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/id")
    @Override
    public ResponseEntity<Company> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(companyService.findById(id).orElseThrow(() -> new ResourceNotFoundException(Company.class.getName())));
    }


    @GetMapping
    @Override
    public ResponseEntity<Set<Company>> findByRequestParams(
            @RequestParam(value = "userId", required = false, defaultValue = "0") Long userId,
            @RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId) {

        Set<Company> companies = new HashSet<>();

        companies.addAll(companyService.findByUserId(userId));
        companies.addAll(companyService.findByAccelerationId(accelerationId));

        return ResponseEntity.ok().body(companies);
    }
}
