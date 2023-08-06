package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CustomerService {

    void add(Customer customer);

    void update(Customer customer);

    Customer detail(Long id);

    void delete(Long id);

    Page<Customer> list(PageRequest pageRequest);

}
