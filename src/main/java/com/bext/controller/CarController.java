package com.bext.controller;

import com.bext.dto.CarDto;
import com.bext.entity.Car;
import com.bext.enums.FuelType;
import com.bext.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {
    @Autowired
    CarMapper carMapper;

    @GetMapping("/car")
    public CarDto carToDto(){
        return carMapper.carTOCarDto( new Car(1,"cartoDto", null));
    }
}
