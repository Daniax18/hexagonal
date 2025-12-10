package com.hexagonal.hexagonal.adapter.in.dto;

import java.sql.Date;

public class CustomerDTO {
    private String name;
    private String email;
    private String mdp;
    private String mdpConfirmed;
    private Date dtn;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public String getMdp() {
        return mdp;
    }

    public Date getDtn() {
        return dtn;
    }

    public String getMdpConfirmed() {
        return mdpConfirmed;
    }
}
