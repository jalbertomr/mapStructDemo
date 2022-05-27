package com.bext.mapper;

import com.bext.dto.CompanyDto;
import com.bext.entity.Company;
import org.mapstruct.Mapper;

@Mapper(uses=EmployeeMapper.class)
public interface CompanyMapper {
    CompanyDto companyToDto(Company company);
}
