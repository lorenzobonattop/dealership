package com.lorenzodev.concessionaria.dto.vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

import com.lorenzodev.concessionaria.models.enums.Fuel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleUpdateDTO {
    private UUID id;
    private String name;
    private String brand;
    private String model;
    private Integer year;
    private Double price;
    private String color;
    private Fuel fuel;
    private String transmission;
    private Integer mileage;
    private String description;
    private Boolean isAvailable;
    private UUID createdById;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}