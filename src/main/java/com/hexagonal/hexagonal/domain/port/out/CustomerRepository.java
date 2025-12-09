package com.hexagonal.hexagonal.domain.port.out;

import com.hexagonal.hexagonal.domain.model.Customer;

public interface CustomerRepository {
    Customer save(Customer customer);
    Customer findByEmail(String email);
    Customer findById(int id);
}
