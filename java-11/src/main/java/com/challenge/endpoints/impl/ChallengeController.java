package com.challenge.endpoints.impl;

import com.challenge.endpoints.interfaces.ChallengeControllerInterface;
import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/challenge")
public class ChallengeController implements ChallengeControllerInterface {

    private ChallengeService challengeService;

    @Override
    @GetMapping
    public ResponseEntity<List<Challenge>> findByAccelerationIdAndUserId(
            @RequestParam(value = "accelerationId", required = false) Long accelerationId,
            @RequestParam(value = "userId", required = false) Long userId) {

        return ResponseEntity.ok().body(challengeService.findByAccelerationIdAndUserId(accelerationId, userId));
    }
}
