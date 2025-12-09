package com.hexagonal.hexagonal.domain.port.in;

import java.sql.Date;

public class CustomerDTO {
    // record CustomerDTO(int id, String name, String email, String tel, String mdp, Date dtn){}
    private Integer id;
    private String name;
    private String email;
    private String tel;
    private String mdp;
    private Date dtn;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String name, String email, String tel, String mdp, Date dtn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.mdp = mdp;
        this.dtn = dtn;
    }

    public CustomerDTO(String name, String email, String tel, String mdp, Date dtn) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.mdp = mdp;
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

    public String getTel() {
        return tel;
    }

    public String getMdp() {
        return mdp;
    }

    public Date getDtn() {
        return dtn;
    }
}
