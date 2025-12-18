package com.hexagonal.hexagonal.domain.service;

import com.hexagonal.hexagonal.domain.model.Customer;
import com.hexagonal.hexagonal.domain.port.in.CustomerUseCaseInterface;
import com.hexagonal.hexagonal.domain.port.out.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements CustomerUseCaseInterface {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void create(CustomerCommand toCreate) throws IllegalArgumentException{
        if(toCreate.mdp().compareTo(toCreate.mdpConfirmed()) != 0) {
            throw new IllegalArgumentException("Password not matched");
        }

        if(findByEmail(toCreate.email()) != null){
            throw new IllegalArgumentException("Email already registered");
        }
        customerRepository.save(new Customer(toCreate.name(), toCreate.email(), toCreate.mdp(), toCreate.dtn()));
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
}
