package com.bext.mapper;

import com.bext.dto.CarDto;
import com.bext.entity.Car;
import com.bext.enums.FuelType;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "fuelType", target="fuelType",defaultValue = "ELECTRIC")
    CarDto carTOCarDto(Car car);
}
