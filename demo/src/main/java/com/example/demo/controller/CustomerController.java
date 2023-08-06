package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.implementation.CustomerServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.example.demo.DemoConstants.MAX_RESULTS_PER_PAGE;

@CrossOrigin(origins = {"http://localhost:5173/", "http://192.168.237.65:5173/"})
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Resource
    private CustomerServiceImpl service;

    @PostMapping(path = "/add", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<?> add(Customer customer) {
        service.add(customer);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

    @PutMapping(path = "/update", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<?> update(Customer customer) {
        service.update(customer);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

    @GetMapping("/detail/{id}")
    private ResponseEntity<?> detail(@PathVariable("id") Long id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.detail(id));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

    @PostMapping("/list")
    private ResponseEntity<?> list(@RequestParam(required = false, defaultValue = "0") Integer page,
                                   @RequestParam(required = false, defaultValue = "asc") String orientation,
                                   @RequestParam(required = false, defaultValue = "lastName") String order) {
        PageRequest pageRequest = PageRequest.of(page, MAX_RESULTS_PER_PAGE, Sort.Direction.valueOf(orientation.toUpperCase()), order);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.list(pageRequest));
    }

}
