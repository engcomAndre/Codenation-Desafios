package com.challenge.endpoints.impl;

import com.challenge.dto.CandidateDTO;
import com.challenge.endpoints.interfaces.CandidateControllerInterface;
import com.challenge.entity.Candidate;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController implements CandidateControllerInterface {

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    @Override
    public ResponseEntity<CandidateDTO> findById(
            @PathVariable(value = "userId") Long userId,
            @PathVariable(value = "companyId") Long companyId,
            @PathVariable(value = "accelerationId") Long accelerationId) {
        return ResponseEntity.ok().body(candidateMapper.map(candidateService.
                findById(userId, companyId, accelerationId).
                orElseThrow(() -> new ResourceNotFoundException(Candidate.class.getName()))));
    }


    @GetMapping
    @Override
    public ResponseEntity<Set<CandidateDTO>> findByRequestParams(
            @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId,
            @RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId) {
        List<Candidate> candidates = new ArrayList<>();

        candidates.addAll(candidateService.findByCompanyId(companyId));
        candidates.addAll(candidateService.findByAccelerationId(accelerationId));

        return ResponseEntity.ok().body(new HashSet<>(candidateMapper.map(candidates)));
    }
}
