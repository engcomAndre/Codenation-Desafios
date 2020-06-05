package com.challenge.endpoints.interfaces;

import com.challenge.dto.CompanyDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyControllerInterface {

    ResponseEntity<CompanyDTO> findById(Long id);

    ResponseEntity<List<CompanyDTO>> findByRequestParams(Long userId, Long accelerationId);

}
