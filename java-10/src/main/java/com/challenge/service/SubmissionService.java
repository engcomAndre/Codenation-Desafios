package com.challenge.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SubmissionService implements SubmissionServiceInterface {

    private final SubmissionRepository submissionRepository;

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        Submission submission = submissionRepository.findFirstScoreById_Challenge_IdOrderByScoreDesc(challengeId).orElse(null);
        return submission != null ? BigDecimal.valueOf(submission.getScore()) : BigDecimal.ZERO;
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission submission) {
        return submissionRepository.save(submission);
    }
}
