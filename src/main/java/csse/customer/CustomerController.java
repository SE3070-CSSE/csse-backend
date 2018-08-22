package csse.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers() {
        return customerService.fetchAll();
    }

    @GetMapping("/customers/{name}")
    public Customer retrieveCustomer(@PathVariable String name) {
        return customerService.fetchByFirstName(name);
    }

    @DeleteMapping("/customers")
    public void dropTable() {
        customerService.cleanDatabase();
    }

    @PostMapping("/customers")
    public ResponseEntity<Object> createStudent(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer.firstName, customer.lastName);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCustomer.firstName).toUri();

        return ResponseEntity.created(location).build();

    }

}
