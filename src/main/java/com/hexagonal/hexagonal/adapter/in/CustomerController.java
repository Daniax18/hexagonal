package com.hexagonal.hexagonal.adapter.in;

import com.hexagonal.hexagonal.domain.model.Customer;
import com.hexagonal.hexagonal.domain.port.in.CustomerDTO;
import com.hexagonal.hexagonal.domain.port.in.CustomerUseCaseInterface;
import com.hexagonal.hexagonal.domain.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerUseCaseInterface customerUseCaseInterface;

    public CustomerController(CustomerUseCaseInterface customerUseCaseInterface) {
        this.customerUseCaseInterface = customerUseCaseInterface;
    }

    @GetMapping("/{id}")
    CustomerDTO get(@PathVariable int id){
        return customerUseCaseInterface.findById(id);
    }

    @GetMapping("/email/{email}")
    CustomerDTO getByEmail(@PathVariable String email){
        return  customerUseCaseInterface.findByEmail(email);
    }

    @PostMapping("/")
    void create(@RequestBody CustomerDTO customerDTO){
        customerUseCaseInterface.create(customerDTO.getName(), customerDTO.getEmail(), customerDTO.getTel(), customerDTO.getMdp(), customerDTO.getDtn());
    }
}
