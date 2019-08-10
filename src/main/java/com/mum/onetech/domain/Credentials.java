package com.mum.onetech.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @OneToOne
    private Role role;

    private Integer verified = 0;

}
