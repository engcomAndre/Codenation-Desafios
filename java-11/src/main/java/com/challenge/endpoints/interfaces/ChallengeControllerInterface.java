package com.challenge.endpoints.interfaces;

import com.challenge.dto.ChallengeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChallengeControllerInterface {

    ResponseEntity<List<ChallengeDTO>> findByAccelerationIdAndUserId(Long accelerationId, Long userId);

}
