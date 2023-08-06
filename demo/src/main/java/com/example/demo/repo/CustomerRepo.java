package com.example.demo.repo;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM Customer c",nativeQuery = true)
    Page<Customer> list(Pageable pageable);
}
