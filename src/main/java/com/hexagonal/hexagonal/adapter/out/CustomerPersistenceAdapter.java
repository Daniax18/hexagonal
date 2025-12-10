package com.hexagonal.hexagonal.adapter.out;

import com.hexagonal.hexagonal.domain.model.Customer;
import com.hexagonal.hexagonal.domain.port.out.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerPersistenceAdapter implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;

    public CustomerPersistenceAdapter(JpaCustomerRepository jpaCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    @Override
    public void save(Customer customer) {
        JpaCustomerEntity customerEntity = new JpaCustomerEntity(customer.getName(), customer.getMdp(), customer.getEmail(), customer.getDtn());
        jpaCustomerRepository.save(customerEntity);
    }

    @Override
    public Customer findByEmail(String email) {
        Optional<JpaCustomerEntity> resultDb = jpaCustomerRepository.findByEmail(email);
        if(resultDb.isPresent()){
            JpaCustomerEntity temp = resultDb.get();
            Customer result =  new Customer(temp.getName(), temp.getEmail(), temp.getMdp(), temp.getDtn());
            result.setId(temp.getCustomerId());
            return result;
        }
        return null;
    }

    @Override
    public Customer findById(int id) {
        Optional<JpaCustomerEntity> resultDb = jpaCustomerRepository.findById(id);
        if(resultDb.isPresent()){
            JpaCustomerEntity temp = resultDb.get();
            Customer result =  new Customer(temp.getName(), temp.getEmail(), temp.getMdp(), temp.getDtn());
            result.setId(temp.getCustomerId());
            return result;
        }
        return null;
    }
}
