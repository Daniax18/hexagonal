package com.hexagonal.hexagonal.domain.valueobject;

public class Contact {
    private String email;
    private String tel;

    public Contact(String email, String tel) throws IllegalArgumentException{
        try {
            this.setEmail(email);
            this.setTel(tel);
        }catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("Error constuctor: " + ex.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException{
        if(!email.contains("@")) throw new IllegalArgumentException("Email need @");
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
