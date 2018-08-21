package csse.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    void cleanDatabase() {
        repository.deleteAll();
    }

    Customer saveCustomer(String fName, String lName) {
        return repository.save(new Customer(fName, lName));
    }

    List<Customer> fetchAll() {
        return  repository.findAll();
    }

    Customer fetchByFirstName(String name) {
        return repository.findByFirstName(name);
    }

    public List<Customer> fetchByLastName(String name) {
        return repository.findByLastName(name);
    }

}
