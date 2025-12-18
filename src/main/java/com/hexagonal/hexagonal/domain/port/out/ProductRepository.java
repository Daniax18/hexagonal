package com.hexagonal.hexagonal.domain.port.out;

import com.hexagonal.hexagonal.domain.model.Product;

public interface ProductRepository {
    Product save(Product product);
    Product findById(int id);
    Product findByName(String name);
}
