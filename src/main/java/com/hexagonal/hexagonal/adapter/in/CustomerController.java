package com.hexagonal.hexagonal.adapter.in;

import com.hexagonal.hexagonal.adapter.in.dto.customer.CustomerDTO;
import com.hexagonal.hexagonal.adapter.in.dto.customer.CustomerResponse;
import com.hexagonal.hexagonal.domain.model.Customer;
import com.hexagonal.hexagonal.domain.port.in.CustomerUseCaseInterface;
import com.hexagonal.hexagonal.domain.port.in.CustomerUseCaseInterface.CustomerCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerUseCaseInterface customerUseCaseInterface;

    public CustomerController(CustomerUseCaseInterface customerUseCaseInterface) {
        this.customerUseCaseInterface = customerUseCaseInterface;
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseData<CustomerResponse>> get(@PathVariable int id){
        try {
            Customer customer = customerUseCaseInterface.findById(id);
            String message = "Customer not found with id : " + id;
            CustomerResponse dataToSend = null;
            if(customer != null){
                dataToSend = new CustomerResponse(
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getDtn()
                );
                message = "Customer found with id " + id;
            }
            ResponseData<CustomerResponse> response = new ResponseData<>(message , dataToSend);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseData<CustomerResponse> response = new ResponseData<>("Error on getting Customer with id : " + id , null);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response); // 404 NOT FOUND
        }
    }

    @GetMapping("/email/{email}")
    ResponseEntity<ResponseData<CustomerResponse>> getByEmail(@PathVariable String email){
        try {
            Customer customer = customerUseCaseInterface.findByEmail(email);
            String message = "Customer not found with email : " + email;
            CustomerResponse dataToSend = null;
            if(customer != null){
                dataToSend = new CustomerResponse(
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getDtn()
                );
                message = "Customer found with email " + email;
            }
            ResponseData<CustomerResponse> response = new ResponseData<>(message , dataToSend);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseData<CustomerResponse> response = new ResponseData<>("Error on getting Customer with email : " + email , null);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response); // 404 NOT FOUND
        }
    }

    @PostMapping("/")
    ResponseEntity<ResponseData<String>> create(@RequestBody CustomerDTO customerDTO){
        try {
            CustomerCommand command = new CustomerCommand(customerDTO.getName(), customerDTO.getEmail(), customerDTO.getMdp(), customerDTO.getMdpConfirmed(), customerDTO.getDtn());
            customerUseCaseInterface.create(command);
            ResponseData<String> response = new ResponseData<>("Customer created !" , null);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException ex) {
            ResponseData<String> response = new ResponseData<>("Error on creating Customer : " + ex.getMessage() , null);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            ResponseData<String> response = new ResponseData<>(e.getMessage() , null);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response); // 404 NOT FOUND
        }
    }
}
