package com.bext.mapper;

import com.bext.dto.CompanyDto;
import com.bext.entity.Company;
import com.bext.entity.Division;
import com.bext.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CompanyMapperTest {
    private CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);

    @Test
    void companyToDtoTest() throws ParseException {
        //given
        Division division = new Division(1, "North");
        Date startDate = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss").parse("2022-06-01 09:00:05");
        Employee employee = new Employee(33L, "Jose Alberto", "Martinez", division, startDate);
        Company company = new Company();
        company.addEmployee(employee);
        //when
        CompanyDto companyDto = companyMapper.companyToDto(company);
        log.info("company: {}", company);
        log.info("companyDto: {}", companyDto);
        //Then
        Assertions.assertEquals(company.getEmployees().get(0).getDivision().getName(),companyDto.getEmployees().get(0).getDivisionDto().getName()
        );
        //...
    }
}