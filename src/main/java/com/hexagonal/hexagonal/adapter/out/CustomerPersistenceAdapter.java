package com.hexagonal.hexagonal.adapter.out;

import com.hexagonal.hexagonal.domain.model.Customer;
import com.hexagonal.hexagonal.domain.port.out.CustomerRepository;
import com.hexagonal.hexagonal.domain.valueobject.Contact;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerPersistenceAdapter implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;

    public CustomerPersistenceAdapter(JpaCustomerRepository jpaCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        JpaCustomerEntity customerEntity = new JpaCustomerEntity(customer.getName(), customer.getMdp(), customer.getContact().getEmail(), customer.getContact().getTel(), customer.getDtn());
        JpaCustomerEntity save = jpaCustomerRepository.save(customerEntity);
        return new Customer(save.getCustomer_id(), save.getName(), save.getMdp(), new Contact(save.getEmail(), save.getTel()), save.getDtn());
    }

    @Override
    public Customer findByEmail(String email) {
        Optional<JpaCustomerEntity> result = jpaCustomerRepository.findByEmail(email);
        if(result.isPresent()){
            JpaCustomerEntity temp = result.get();
            return new Customer(temp.getCustomer_id(), temp.getName(), temp.getMdp(), new Contact(temp.getEmail(), temp.getTel()), temp.getDtn());
        }
        return null;
    }

    @Override
    public Customer findById(int id) {
        Optional<JpaCustomerEntity> result = jpaCustomerRepository.findById(id);
        if(result.isPresent()){
            JpaCustomerEntity temp = result.get();
            return new Customer(temp.getCustomer_id(), temp.getName(), temp.getMdp(), new Contact(temp.getEmail(), temp.getTel()), temp.getDtn());
        }
        return null;
    }
}
