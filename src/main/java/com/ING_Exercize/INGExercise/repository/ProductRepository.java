package com.ING_Exercize.INGExercise.repository;

import com.ING_Exercize.INGExercise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByName(String name);

}
