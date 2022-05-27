package com.bext.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private Division division;
    private Date startDate;
}
