package com.bext.dto;

import com.bext.entity.Division;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private long employeeId;
    private String employeeName;
    private DivisionDto divisionDto = new DivisionDto();
    private String employeeStartDate;
}
