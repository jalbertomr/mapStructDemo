package com.bext.mapper;

import com.bext.dto.CarDto;
import com.bext.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto carTOCarDto(Car car);
}
