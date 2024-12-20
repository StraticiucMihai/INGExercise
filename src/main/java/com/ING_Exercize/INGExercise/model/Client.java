package com.ING_Exercize.INGExercise.model;

import com.ING_Exercize.INGExercise.config.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private Roles role; // example: "ROLE_ADMIN" or "ROLE_USER"
}
