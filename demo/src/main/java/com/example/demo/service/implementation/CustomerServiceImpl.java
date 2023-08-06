package com.example.demo.service.implementation;

import com.example.demo.exception.RequestSystemException;
import com.example.demo.exception.RequestValidationException;
import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.demo.DemoConstants.DATA_ACCESS_EXCEPTION;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public void add(Customer customer) {
        try {
            repo.save(customer);
        }
        catch (DataAccessException e) {
            throw new RequestSystemException(DATA_ACCESS_EXCEPTION, Collections.singletonList(e.getMessage()));
        }
    }

    @Override
    public void update(Customer customer) {
        Optional<Customer> customerOptional = repo.findById(customer.getId());
        if(customerOptional.isPresent()) {
            try {
                repo.save(customer);
            }
            catch (DataAccessException e) {
                throw new RequestSystemException(DATA_ACCESS_EXCEPTION, Collections.singletonList(e.getMessage()));
            }

        }
        else
            throw new RequestValidationException("El cliente no existe en BDD");
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
    public Page<Customer> list(PageRequest pageRequest) {
        try {
            return repo.list(pageRequest);
        }
        catch (DataAccessException e) {
            throw new RequestSystemException(DATA_ACCESS_EXCEPTION, Collections.singletonList(e.getMessage()));
        }
    }

}
