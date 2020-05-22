package com.challenge.endpoints.impl;

import com.challenge.dto.SubmissionDTO;
import com.challenge.endpoints.interfaces.SubmissionControllerInterface;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@RestController
@RequestMapping(value = "/submission")
public class SubmissionController implements SubmissionControllerInterface {

    private SubmissionService submissionService;

    private SubmissionMapper submissionMapper;

    @GetMapping
    @Override
    public ResponseEntity<Set<SubmissionDTO>> findByChallengeIdAndAccelerationId(
            @RequestParam(value = "challengeId", required = true, defaultValue = "0") Long challengeId,
            @RequestParam(value = "accelerationId", required = true, defaultValue = "0") Long accelerationId) {

        List<Submission> submissions = new ArrayList<>(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));

        return ResponseEntity.ok().body(new HashSet<>(submissionMapper.map(submissions)));

    }
}
