package com.challenge.endpoints.interfaces;

import com.challenge.dto.AccelerationDTO;
import com.challenge.entity.Acceleration;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccelerationControllerInterface {

    ResponseEntity<AccelerationDTO> findById(Long id);

    ResponseEntity<List<AccelerationDTO>> findByCompanyId(Long companyId);
}

