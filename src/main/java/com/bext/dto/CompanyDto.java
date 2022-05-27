package com.bext.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private List<EmployeeDto> employees;

    public List<EmployeeDto> getEmployees(){
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees){
        this.employees = employees;
    }

    public boolean addEmployee( EmployeeDto employeeDto){
        if ( employees == null){
            employees = new ArrayList<>();
        }
        return employees.add(employeeDto);
    }
}
