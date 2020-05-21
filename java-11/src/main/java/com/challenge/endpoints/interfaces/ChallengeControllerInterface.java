package com.challenge.endpoints.interfaces;

import com.challenge.entity.Challenge;
import com.challenge.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChallengeControllerInterface {

    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);

}
