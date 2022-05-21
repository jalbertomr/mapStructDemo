package com.bext.spring;

import com.bext.dto.CarDto;
import com.bext.entity.Car;
import com.bext.mapper.CarMapper;
import com.bext.mapper.SimpleSourceDestinationMapper;
import com.bext.pojo.SimpleSource;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringMapStructApplication implements CommandLineRunner {
//    private SimpleSourceDestinationMapper mapper = Mappers.getMapper(SimpleSourceDestinationMapper.class);

    public static void main(String... args){
        SpringApplication.run(SpringMapStructApplication.class, args).close();
    }

    @Override
    public void run(String... args) throws Exception {
        Car car = new Car();
        car.setId(1);
        CarDto carDto = CarMapper.INSTANCE.carTOCarDto(car);
        System.out.println(car);
        System.out.println(carDto);
    }
}
