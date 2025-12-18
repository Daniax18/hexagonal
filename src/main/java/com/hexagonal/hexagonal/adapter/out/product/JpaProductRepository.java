package com.hexagonal.hexagonal.adapter.out.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaProductRepository extends JpaRepository<JpaProductEntity, Integer> {
    Optional<JpaProductEntity> findByName(String name);
}
