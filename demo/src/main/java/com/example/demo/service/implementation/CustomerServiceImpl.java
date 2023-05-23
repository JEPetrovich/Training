package com.example.demo.service.implementation;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public Customer add(Customer customer) { return repo.save(customer); }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> customerOptional = repo.findById(customer.getId());
        if(customerOptional.isPresent())
            return repo.save(customer);
        else
            return null;
    }

    @Override
    public Customer detail(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);
        return customerOptional.orElse(null);
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);
        customerOptional.ifPresent(customer -> repo.delete(customer));
    }

    @Override
    public List<Customer> list() { return repo.findAll(); }

}
