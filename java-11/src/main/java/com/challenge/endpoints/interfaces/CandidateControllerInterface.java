package com.challenge.endpoints.interfaces;

import com.challenge.dto.CandidateDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CandidateControllerInterface {
    ResponseEntity<CandidateDTO> findById(Long userId, Long companyId, Long accelerationId);

    ResponseEntity<Set<CandidateDTO>> findByRequestParams(Long companyId, Long accelerationId);
}
