package com.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDTO {

    private Long challengeId;
    private String userId;
    private BigDecimal score;
    private String createdAt;

}
