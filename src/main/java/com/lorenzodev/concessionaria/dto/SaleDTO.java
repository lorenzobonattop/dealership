package com.lorenzodev.concessionaria.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.lorenzodev.concessionaria.models.enums.PaymentMethod;
import com.lorenzodev.concessionaria.models.enums.SaleStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO{
    private UUID id;
    private UUID vehicleId;
    private UUID customerId;
    private UUID sellerId;
    private LocalDateTime saleDate;
    private Double salePrice;
    private PaymentMethod paymentMethod;
    private SaleStatus status;
    private String notes;
}