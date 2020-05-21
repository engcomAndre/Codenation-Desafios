package com.challenge.endpoints.interfaces;

import com.challenge.entity.Acceleration;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccelerationControllerInterface {

    ResponseEntity<Acceleration> findById(Long id);

    ResponseEntity<List<Acceleration>> findByCompanyId(Long companyId);
}

