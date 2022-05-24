package com.bext.entity;

import com.bext.enums.FuelType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int id;
    private String name;
    private FuelType fuelType;
}
