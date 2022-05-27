package com.bext.mapper;

import com.bext.dto.CarDto;
import com.bext.entity.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class CarMapperUnitTest {

    @Test
    public void carToCarDto(){

        Car car = new Car();
        car.setId(1);
        car.setName("Honda");

        CarDto carDto = CarMapper.INSTANCE.carTOCarDto(car);
        Assertions.assertEquals(carDto.getId(), car.getId());
    }
}
