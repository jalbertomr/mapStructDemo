package com.bext.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarDto {
    private int id;
    private String name;
    private FuelType fuelType;
}
