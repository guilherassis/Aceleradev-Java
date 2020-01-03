package com.challenge.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity(name = "candidate")
@Data
@EntityListeners(Candidate.class)

public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @EmbeddedId
    private CandidateId id;

    @NotNull
    @Column(name = "status")
    private int status;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdat;


    @Embeddable
    public class CandidateId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "acceleration_id")
        private Acceleration acceleration;

        @ManyToOne
        @JoinColumn(name = "company_id")
        private Company company;
    }

}
