package com.lorenzodev.concessionaria.dto.vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

import com.lorenzodev.concessionaria.models.Vehicle;
import com.lorenzodev.concessionaria.models.enums.Fuel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponseDTO {
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
    private String sellerName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static VehicleResponseDTO fromEntity(Vehicle vehicle) {
        return VehicleResponseDTO.builder()
            .id(vehicle.getId())
            .name(vehicle.getName())
            .brand(vehicle.getBrand())
            .model(vehicle.getModel())
            .year(vehicle.getYear())
            .price(vehicle.getPrice())
            .color(vehicle.getColor())
            .fuel(vehicle.getFuel())
            .transmission(vehicle.getTransmission())
            .mileage(vehicle.getMileage())
            .description(vehicle.getDescription())
            .isAvailable(vehicle.getIsAvailable())
            .sellerName(vehicle.getCreatedBy() != null ? vehicle.getCreatedBy().getName() : null)
            .createdAt(vehicle.getCreatedAt())
            .updatedAt(vehicle.getUpdatedAt())
            .build();
    }
} 