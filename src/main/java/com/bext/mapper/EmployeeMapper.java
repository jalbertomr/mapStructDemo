package com.bext.mapper;

import com.bext.dto.EmployeeDto;
import com.bext.entity.Employee;
import com.bext.mapConverter.DateConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper(uses= DateConverter.class)
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "id", target = "employeeId")
    @Mapping(target = "employeeName", expression = "java(employee.getFirstName() + \" \" + employee.getLastName() )")
    @Mapping(source = "startDate", target = "employeeStartDate", dateFormat = "YYYY-mm-dd HH:mm:ss")
    @Mapping(source = "employee.division.id", target="divisionDto.id")
    EmployeeDto employeeToDto(Employee employee);

    @Mapping(source = "employeeId", target = "id")
    @Mapping(target = "firstName", expression = "java(employeeDto.getEmployeeName() )")
    @Mapping(target = "lastName", expression = "java(employeeDto.getEmployeeName() )")
    @Mapping(source = "employeeStartDate", target = "startDate", dateFormat = "YYYY-mm-dd HH:mm:ss")
    @Mapping(source="employeeDto.divisionDto.id", target="division.id")
    @Mapping(source="employeeDto.divisionDto.name", target="division.name")
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> employeesListToDto(List<Employee> employees);

    Set<EmployeeDto> employeesSetToDto(Set<Employee> employees);

    Map<String, EmployeeDto> employeesMapToDto(Map<String, Employee> employee);
}
