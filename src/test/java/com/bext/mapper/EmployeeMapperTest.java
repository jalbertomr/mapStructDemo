package com.bext.mapper;

import com.bext.dto.DivisionDto;
import com.bext.dto.EmployeeDto;
import com.bext.entity.Division;
import com.bext.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class EmployeeMapperTest {

    @Test  //Employee -> EmployeeDto
    void mapEmployeeTest() throws ParseException {
        //given
        Division division = new Division(1, "North");
        Date startDate = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss").parse("2022-06-01 09:00:05");
        Employee employee = new Employee( 23, "Jose Alberto", "Martinez", division, startDate);
        //when
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.employeeToDto(employee);
        log.info("employee: {}", employee);
        log.info("employeeDto: {}", employeeDto);
        //then
        Assertions.assertEquals(23, employeeDto.getEmployeeId());
        Assertions.assertEquals( employee.getFirstName() + " " + employee.getLastName(), employeeDto.getEmployeeName());
        Assertions.assertEquals( division.getId(), employeeDto.getDivisionDto().getId());
        Assertions.assertEquals( division.getName(), employeeDto.getDivisionDto().getName());
    }

    @Test
    void employeeDtoToEmployeeTest() {
        //given
        DivisionDto divisionDto = new DivisionDto(3,"PACIFIC","WESTERN");
        EmployeeDto employeeDto = new EmployeeDto(102, "Jose Alberto Martinez", divisionDto, "2022-06-01 09:10:05");
        Employee employee = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
        //then
        log.info("employeeDto: {}", employeeDto);
        log.info("employee: [{}]", employee);
        Assertions.assertEquals(employee.getId(), employeeDto.getEmployeeId());
        Assertions.assertEquals(employee.getFirstName(), employeeDto.getEmployeeName());
        Assertions.assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(employee.getStartDate()), employeeDto.getEmployeeStartDate());
        Assertions.assertEquals(employee.getDivision().getId(),employeeDto.getDivisionDto().getId());
        Assertions.assertEquals(employee.getDivision().getName(),employeeDto.getDivisionDto().getName());
    }

    @Test
    void employeesListToDto() throws ParseException {
        //given
        Division division = new Division(1, "North");
        Date startDate = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss").parse("2022-06-01 09:00:05");
        Employee employee = new Employee(33L, "Jose Alberto", "Martinez", division, startDate);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        //when
        List<EmployeeDto> employeesDto = EmployeeMapper.INSTANCE.employeesListToDto(employees);
        //then
        System.out.println(employees);
        System.out.println(employeesDto);

        Assertions.assertEquals(employees.get(0).getId(), employeesDto.get(0).getEmployeeId());
        Assertions.assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(employees.get(0).getStartDate()),employeesDto.get(0).getEmployeeStartDate());
        Assertions.assertEquals(employees.get(0).getDivision().getName(),employeesDto.get(0).getDivisionDto().getName());
        //...
    }

    @Test
    void employeesSetToDto() throws ParseException {
        //given
        Division division = new Division(1, "North");
        Date startDate = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss").parse("2022-06-01 09:00:05");
        Employee employee = new Employee(33L, "Jose Alberto", "Martinez", division, startDate);
        Set<Employee> employeesSet = new HashSet<>();
        employeesSet.add( employee);
        //when
        Set<EmployeeDto> employeesDtoSet = EmployeeMapper.INSTANCE.employeesSetToDto(employeesSet);
        log.info("employeesSet: {} ", employeesSet);
        log.info("employeesDtoSet: {} ", employeesDtoSet);
        //then
        Assertions.assertEquals(employeesSet.iterator().next().getDivision().getName(),employeesDtoSet.iterator().next().getDivisionDto().getName());
        //...
    }

    @Test
    void employeesMaoToDto() throws ParseException {
        //given
        Division division = new Division(1, "North");
        Date startDate = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss").parse("2022-06-01 09:00:05");
        Employee employee = new Employee(33L, "Jose Alberto", "Martinez", division, startDate);
        Map<String,Employee> employeesMap = new HashMap<>();
        employeesMap.put("emp1" ,employee);
        //when
        Map<String,EmployeeDto> employeesDtoMap = EmployeeMapper.INSTANCE.employeesMapToDto(employeesMap);
        log.info("employeesMap: {} ", employeesMap);
        log.info("employeesDtoMap: {} ", employeesDtoMap);
        //then
        Assertions.assertEquals(employeesMap.get("emp1").getDivision().getName(),employeesDtoMap.get("emp1").getDivisionDto().getName());
    }
}