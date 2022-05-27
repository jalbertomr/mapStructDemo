package com.bext.mapper;

import com.bext.dto.CustomerDto;
import com.bext.entity.Customer;
import com.bext.entity.Title;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( uses=TitleMapper.class, componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "customerId", source = "id")
    @Mapping(target = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "fullName", expression = "java(customer.getFirstName() + \" \" + customer.getLastName())")
    CustomerDto customerToDto(Customer customer);

    @Mapping(target = "id", source = "customerId")
    @Mapping(target = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "title.name", source="title")
    Customer customerDtoToCustomer(CustomerDto customerDto);

    default String toString(Title title){
        return title.getName();
    }
}
