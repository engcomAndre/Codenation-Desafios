package com.challenge.endpoints.interfaces;

import com.challenge.entity.Company;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CompanyControllerInterface {

    ResponseEntity<Company> findById(Long id);

    ResponseEntity<Set<Company>> findByRequestParams(Long userId, Long accelerationId);

}
