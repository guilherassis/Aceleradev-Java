package com.challenge.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

@Entity(name = "acceleration")
@Data
@EntityListeners(Acceleration.class)

public class Acceleration {

		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@NotNull
	@Column(name = "id")
    private int id;

	@Size(max = 100)
	@NotNull
	@Column(name = "name")
	private String name;

	@Size(max = 50)
	@NotNull
	@Column(name = "slug")
	private String slug;

	@NotNull
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdat;


	@OneToMany(mappedBy = "id", cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	List<Candidate> listcandidate = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "challenge_id")
	private Challenge challenge;

}
