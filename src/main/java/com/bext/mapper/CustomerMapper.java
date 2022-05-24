package com.bext.mapper;

import com.bext.dto.CustomerDto;
import com.bext.entity.Customer;
import com.bext.entity.Title;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses=AddressMapper.class, componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "customerId", source = "id")
    @Mapping(target = "dateOfBirth", dateFormat = "dd.MM.yyyy")
    @Mapping(target = "fullName", expression = "java(customer.getFirstName() + \" \" + customer.getLastName())")
    CustomerDto customerToDto(Customer customer);

    default String toString(Title title){
        return title.getName();
    }
}
