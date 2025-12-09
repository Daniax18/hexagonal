package com.hexagonal.hexagonal.domain.port.in;

import java.sql.Date;

public interface CustomerUseCaseInterface {
    void create(String name, String email, String tel, String mdp, Date dtn);
    CustomerDTO findByEmail(String email);
    CustomerDTO findById(int id);
}
