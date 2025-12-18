package com.hexagonal.hexagonal.domain.service;

import com.hexagonal.hexagonal.domain.model.Product;
import com.hexagonal.hexagonal.domain.port.in.ProductUseCase;
import com.hexagonal.hexagonal.domain.port.out.ProductRepository;

public class ProductService implements ProductUseCase {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product createProduct(CreateProductCommand product) {
        Product verify = findByName(product.name());
        if(verify != null) throw new IllegalArgumentException("Product already exist.");

        Product toCreate = new Product(product.name(), product.description(), product.price());
        return productRepository.save(toCreate);
    }
}
