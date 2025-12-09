package com.hexagonal.hexagonal.domain.service;

import com.hexagonal.hexagonal.domain.model.Customer;
import com.hexagonal.hexagonal.domain.port.in.CustomerDTO;
import com.hexagonal.hexagonal.domain.port.in.CustomerUseCaseInterface;
import com.hexagonal.hexagonal.domain.port.out.CustomerRepository;
import com.hexagonal.hexagonal.domain.valueobject.Contact;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class CustomerService implements CustomerUseCaseInterface {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void create(String name, String email, String tel, String mdp, Date dtn) {
        customerRepository.save(new Customer(name, mdp, new Contact(email, tel), dtn));
    }

    @Override
    public CustomerDTO findByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getContact().getEmail(), customer.getContact().getTel(), customer.getMdp(), customer.getDtn());
    }

    @Override
    public CustomerDTO findById(int id) {
        Customer customer = customerRepository.findById(id);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getContact().getEmail(), customer.getContact().getTel(), customer.getMdp(), customer.getDtn());
    }
}
