package com.ING_Exercize.INGExercise.repository;

import com.ING_Exercize.INGExercise.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Client,Long> {

    Optional<Client> findByName(String name);
}
