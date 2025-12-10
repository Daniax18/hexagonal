package com.hexagonal.hexagonal.adapter.out;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "customer")
public class JpaCustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_mdp")
    private String mdp;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_dtn")
    private Date dtn;

    public JpaCustomerEntity() {
    }

    public JpaCustomerEntity(String name, String mdp, String email, Date dtn) {
        this.name = name;
        this.mdp = mdp;
        this.email = email;
        this.dtn = dtn;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }
}
