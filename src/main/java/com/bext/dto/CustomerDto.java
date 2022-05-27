package com.bext.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    public long customerId;
    public String fullName;
    public double creditScore;
    public String dateOfBirth;
    public LocalDate creation;
    public String title;
    public AddressDto address;
}
