package com.hexagonal.hexagonal.domain.port.in;

import com.hexagonal.hexagonal.domain.model.Customer;

import java.sql.Date;

public interface CustomerUseCaseInterface {
    void create(CustomerCommand customerToCreate);
    Customer findByEmail(String email);
    Customer findById(int id);

    public record CustomerCommand(
            String name,
            String email,
            String mdp,
            String mdpConfirmed,
            Date dtn
    ) {}
}
