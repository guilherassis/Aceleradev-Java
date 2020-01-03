package com.challenge.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

@Entity(name = "submission")
@Data
@EntityListeners(Submission.class)

public class Submission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@EmbeddedId
	private SubmissionId id;

	@NotNull
	@Column(name = "score")
	private float score;

	@NotNull
	@CreatedDate
	@Column(name = "created_at")
    private LocalDateTime createdat;

	@Embeddable
	public class SubmissionId implements Serializable {

		@ManyToOne
		@JoinColumn(name = "user_id")
		private User user;

		@ManyToOne
		@JoinColumn(name = "challenge_id")
		private Challenge challenge;
	}

}
