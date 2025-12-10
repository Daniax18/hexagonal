package com.hexagonal.hexagonal.domain.model;

import java.sql.Date;

public class Customer {
    private int id;
    private String name;
    private String mdp;
    private String email;
    private Date dtn;

    public Customer(String name, String email, String mdp,Date dtn) throws IllegalArgumentException {
        try {
            this.setName(name);
            this.setEmail(email);
            this.setMdp(mdp);
            this.setDtn(dtn);
        }catch (IllegalArgumentException ex){
            //  Message have to be short to avoid:
            // "Error on creating Customer with error : Error on constructing the object Customer. Under 18 years old are not allowed"
            throw new IllegalArgumentException("Error on constructing the object Customer. " + ex.getMessage());
        }
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

    public void setName(String name) throws IllegalArgumentException{
        if(name.trim().compareTo("") == 0) throw new IllegalArgumentException("Name should not empty");
        this.name = name;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) throws IllegalArgumentException{
        if(!isValidPassword(mdp)) throw new IllegalArgumentException("Password not valid");
        this.mdp = mdp;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) throws IllegalArgumentException{
        int year = dtn.toLocalDate().getYear();
        int yearNow = java.time.LocalDate.now().getYear();

        if((yearNow - year) < 18) throw new IllegalArgumentException("Under 18 years old are not allowed");
        this.dtn = dtn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws  IllegalArgumentException{
        if(!email.contains("@")) throw new IllegalArgumentException("Email should have @");
        this.email = email;
    }

    public boolean isValidPassword(String mdpToCheck){
        boolean hasSpecial = mdpToCheck.matches(".*[^a-zA-Z0-9].*");
        return hasSpecial && mdpToCheck.length() >= 10;
    }
}
