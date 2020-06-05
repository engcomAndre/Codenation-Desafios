package com.challenge.endpoints.impl;

import com.challenge.dto.CompanyDTO;
import com.challenge.endpoints.interfaces.CompanyControllerInterface;
import com.challenge.entity.Company;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.mappers.CompanyMapper;
import com.challenge.service.impl.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/company")
public class CompanyController implements CompanyControllerInterface {

    private CompanyService companyService;

    private CompanyMapper companyMapper;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok()
                .body(companyMapper
                        .map(companyService
                                .findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(Company.class.getName()))));
    }


    @Override
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findByRequestParams(
            @RequestParam(value = "userId", required = false, defaultValue = "0") Long userId,
            @RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId) {

        Set<Company> companies = new HashSet<>();

        if (userId != 0) companies.addAll(companyService.findByUserId(userId));
        if (accelerationId != 0) companies.addAll(companyService.findByAccelerationId(accelerationId));

        return ResponseEntity
                .ok()
                .body(companyMapper
                        .map(companies));
    }
}
