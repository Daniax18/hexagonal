package com.hexagonal.hexagonal.domain.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price) throws IllegalArgumentException{
        try {
            this.setName(name);
            this.setDescription(description);
            this.setPrice(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IllegalArgumentException{
        int wordNumber = (description.split(" ")).length;
        if(wordNumber < 3) throw new IllegalArgumentException("Description should be at least 3 words");
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price)throws IllegalArgumentException {
        if(price < 0) throw new IllegalArgumentException("Price should be positive value");
        this.price = price;
    }
}
