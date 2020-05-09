package com.challenge.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Embeddable
public class CandidateId {

    @ManyToOne
    private User user;

    @ManyToOne
    private Acceleration acceleration;

    @ManyToOne
    private Company company;

    @CreatedDate
    private LocalDate createdAt;

}
