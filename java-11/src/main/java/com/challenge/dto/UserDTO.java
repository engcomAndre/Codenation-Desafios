package com.challenge.dto;


import com.challenge.entity.Candidate;
import com.challenge.entity.Submission;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull
    @Size(max = 100)
    private String fullName;

    @Email
    @Size(max = 100)
    @NotNull
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

}
