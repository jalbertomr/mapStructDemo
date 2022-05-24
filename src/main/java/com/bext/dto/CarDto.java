package com.bext.dto;

import com.bext.enums.FuelType;
import lombok.Data;

@Data
public class CarDto {
    private int id;
    private String name;
    private FuelType fuelType;
}
