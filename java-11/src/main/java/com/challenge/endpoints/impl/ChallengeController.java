package com.challenge.endpoints.impl;

import com.challenge.dto.ChallengeDTO;
import com.challenge.endpoints.interfaces.ChallengeControllerInterface;
import com.challenge.mappers.ChallengeMapper;
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

    private ChallengeMapper challengeMapper;

    @Override
    @GetMapping
    public ResponseEntity<List<ChallengeDTO>> findByAccelerationIdAndUserId(
            @RequestParam(value = "accelerationId", required = false) Long accelerationId,
            @RequestParam(value = "userId", required = false) Long userId) {

        return ResponseEntity
                .ok()
                .body(challengeMapper
                        .map(challengeService
                                .findByAccelerationIdAndUserId(accelerationId, userId)));
    }
}
