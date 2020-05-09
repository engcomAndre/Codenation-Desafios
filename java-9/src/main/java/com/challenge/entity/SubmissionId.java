package com.challenge.entity;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Data
@Embeddable
public class SubmissionId {
    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;
}
