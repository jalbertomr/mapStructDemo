package com.bext.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDto {
    public long customerId;
    public String firstName;
    public String lastName;
    public double creditScore;
    public String dateOfBirth;
    public LocalDate creation;
    public String title;
    public AddressDto address;
    public String fullName;
}
