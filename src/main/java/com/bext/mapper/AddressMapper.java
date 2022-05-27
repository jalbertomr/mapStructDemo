package com.bext.mapper;

import com.bext.dto.AddressDto;
import com.bext.entity.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {
    public AddressDto addressToDto(Address address);
}
