package com.hexagonal.hexagonal.domain.port.in;

import com.hexagonal.hexagonal.domain.model.Product;

import java.sql.Date;

public interface ProductUseCase {
    Product findById(int id);
    Product findByName(String name);
    Product createProduct(CreateProductCommand product);

    public  record CreateProductCommand(
            String name,
            String description,
            double price
    ) {}
}
