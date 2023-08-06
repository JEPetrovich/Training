package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
    @Column
    private LocalDateTime dateOfBirth;
    @Column
    private String mail;

}

