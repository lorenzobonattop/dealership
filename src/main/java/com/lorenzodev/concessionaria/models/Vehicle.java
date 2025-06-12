package com.lorenzodev.concessionaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.*;
import jakarta.validation.constraints.*;

import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "A marca é obrigatória")
    @Column(name = "brand", nullable = false)
    private String brand;

    @NotBlank(message = "O modelo é obrigatório")
    @Column(name = "model", nullable = false)
    private String model;

    @NotNull(message = "O ano é obrigatório")
    @Min(value = 1900, message = "O ano deve ser maior que 1900")
    @Max(value = 2024, message = "O ano não pode ser maior que o atual")
    @Column(name = "year_car", nullable = false)
    private Integer year;

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotBlank(message = "A cor é obrigatória")
    @Column(name = "color", nullable = false)
    private String color;

    @NotBlank(message = "O tipo de combustível é obrigatório")
    @Column(name = "fuel", nullable = false)
    private String fuel;

    @NotBlank(message = "A transmissão é obrigatória")
    @Column(name = "transmission", nullable = false)
    private String transmission;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
    
