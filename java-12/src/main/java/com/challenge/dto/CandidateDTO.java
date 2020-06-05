package com.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {

    private Long userId;
    private Long accelerationId;
    private Long companyId;
    private Integer status;
    private String createdAt;

}
