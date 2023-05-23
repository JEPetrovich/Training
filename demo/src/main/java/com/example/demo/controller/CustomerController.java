package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.implementation.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/demo")
public class CustomerController {

    @Resource
    private CustomerServiceImpl service;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(service.add(customer));
    }

    @PutMapping("/update")
    private ResponseEntity<?> update(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(service.update(customer));
    }

    @GetMapping("/detail/{id}")
    private ResponseEntity<?> detail(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.detail(id));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    private ResponseEntity<?> list() {
        return ResponseEntity.ok().body(service.list());
    }

}
