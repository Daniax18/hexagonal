package com.hexagonal.hexagonal.adapter.in.dto.customer;

import java.sql.Date;

public class CustomerResponse {
    private Integer id;
    private String name;
    private String email;
    private Date dtn;

    public CustomerResponse() {
    }

    public CustomerResponse(Integer id, String name, String email, Date dtn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dtn = dtn;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getDtn() {
        return dtn;
    }
}
