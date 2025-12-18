package com.hexagonal.hexagonal.adapter.out.product;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class JpaProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String name;



    @Column(name = "product_description")
    private String description;

    @Column(name = "product_price")
    private Double price;

    public JpaProductEntity() {
    }

    public JpaProductEntity(String name, String description, Double price) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
