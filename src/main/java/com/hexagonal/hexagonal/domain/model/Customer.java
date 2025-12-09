package com.hexagonal.hexagonal.domain.model;

import com.hexagonal.hexagonal.domain.valueobject.Contact;

import java.sql.Date;

public class Customer {
    private int id;
    private String name;
    private String mdp;
    private Contact contact;
    private Date dtn;


    public Customer(String name, String mdp, Contact contact, Date dtn) {
        this.name = name;
        this.mdp = mdp;
        this.contact = contact;
        this.dtn = dtn;
    }

    public Customer(int id, String name, String mdp, Contact contact, Date dtn) {
        this.id = id;
        this.name = name;
        this.mdp = mdp;
        this.contact = contact;
        this.dtn = dtn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }
}
