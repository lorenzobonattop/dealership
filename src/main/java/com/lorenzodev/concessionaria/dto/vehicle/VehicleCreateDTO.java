package com.lorenzodev.concessionaria.dto.vehicle;

import java.util.UUID;

import com.lorenzodev.concessionaria.models.enums.Fuel;
import com.lorenzodev.concessionaria.validation.CurrentYear;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleCreateDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "A marca é obrigatória")
    private String brand;

    @NotBlank(message = "O modelo é obrigatório")
    private String model;

    @NotNull(message = "O ano é obrigatório")
    @Min(value = 1900, message = "O ano deve ser maior que 1900")
    @CurrentYear
    private Integer year;

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private Double price;

    @NotBlank(message = "A cor é obrigatória")
    private String color;

    @NotNull(message = "O tipo de combustível é obrigatório")
    private Fuel fuel;

    @NotBlank(message = "A transmissão é obrigatória")
    private String transmission;

    @Positive(message = "A quilometragem deve ser maior que zero")
    private Integer mileage;

    private String description;

    @NotNull(message = "O vendedor é obrigatório")
    private UUID createdById;
} 