package com.bext.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    //private Title title;
    private LocalDate dateOfBirth;
    private BigDecimal creditScore;
    private CustomerType customerType;
    private Address address;
    private Date creation;
}
