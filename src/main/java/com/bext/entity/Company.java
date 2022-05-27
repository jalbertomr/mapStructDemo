package com.bext.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    };

    public void setEmployees( List<Employee> employees) {
        this.employees = employees;
    }

    public boolean addEmployee(Employee employee){
        if (employees == null){
            employees = new ArrayList<>();
        }
        return employees.add(employee);
    }
}
