package com.challenge.endpoints.interfaces;

import com.challenge.dto.SubmissionDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface SubmissionControllerInterface {

    ResponseEntity<Set<SubmissionDTO>> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
