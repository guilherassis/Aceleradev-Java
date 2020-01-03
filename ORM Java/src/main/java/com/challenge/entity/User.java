package com.challenge.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "user")
@EntityListeners(User.class)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    @Column(name = "id")
    private int id;

    @Size(max=100)
    @NotNull
    @Column(name = "full_name")
    private String fullname;

    @Size(max=100)
    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @Size(max=50)
    @NotNull
    @Column(name = "nickname")
    private String nickname;

    @Size(max=255)
    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdat;

    @OneToMany(mappedBy = "id", cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    List<Candidate> listcandidate = new ArrayList<>();

    @OneToMany(mappedBy = "id", cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    List<Submission> listsubmission = new ArrayList<>();


}
