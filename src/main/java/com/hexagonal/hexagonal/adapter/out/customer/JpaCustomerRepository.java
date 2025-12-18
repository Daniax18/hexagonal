package com.hexagonal.hexagonal.adapter.out.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomerEntity, Integer> {
    Optional<JpaCustomerEntity> findByEmail(String email);
}
