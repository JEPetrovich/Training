package com.example.demo.service;

import com.example.demo.model.Customer;
import java.util.List;

public interface CustomerService {

    Customer add(Customer customer);

    Customer update(Customer customer);

    Customer detail(Long id);

    void delete(Long id);

    List<Customer> list();

}
