package com.bext.mapper;

import com.bext.dto.CompanyDto;
import com.bext.entity.Company;
import com.bext.entity.Employee;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

@Mapper(uses= EmployeeMapper.class, collectionMappingStrategy= CollectionMappingStrategy.ADDER_PREFERRED)
public interface CompanyMapperAdderPreferred {
    CompanyDto companyToDto(Company company);
}
