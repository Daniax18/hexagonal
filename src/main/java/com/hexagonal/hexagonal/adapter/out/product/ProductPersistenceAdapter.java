package com.hexagonal.hexagonal.adapter.out.product;

import com.hexagonal.hexagonal.domain.model.Product;
import com.hexagonal.hexagonal.domain.port.out.ProductRepository;

import java.util.Optional;

public class ProductPersistenceAdapter implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public ProductPersistenceAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product save(Product product) {
        JpaProductEntity entity = jpaProductRepository.save(
                new JpaProductEntity(product.getName(), product.getDescription(), product.getPrice())
        );
        Product result = new Product(entity.getName(), entity.getDescription(), entity.getPrice());
        result.setId(entity.getProductId());
        return result;
    }

    @Override
    public Product findById(int id) {
        Optional<JpaProductEntity> temp = jpaProductRepository.findById(id);
        if(temp.isPresent()){
            JpaProductEntity entity = temp.get();
            Product result = new Product(entity.getName(), entity.getDescription(), entity.getPrice());
            result.setId(entity.getProductId());
            return result;
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        Optional<JpaProductEntity> temp = jpaProductRepository.findByName(name);
        if(temp.isPresent()){
            JpaProductEntity entity = temp.get();
            Product result = new Product(entity.getName(), entity.getDescription(), entity.getPrice());
            result.setId(entity.getProductId());
            return result;
        }
        return null;
    }
}
