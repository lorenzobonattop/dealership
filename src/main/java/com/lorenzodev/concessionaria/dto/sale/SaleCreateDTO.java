package com.lorenzodev.concessionaria.dto.sale;

import java.time.LocalDateTime;
import java.util.UUID;

import com.lorenzodev.concessionaria.models.enums.PaymentMethod;
import com.lorenzodev.concessionaria.models.enums.SaleStatus;

public class SaleCreateDTO {
    private UUID id;
    private UUID vehicleId;
    private UUID customerId;
    private UUID sellerId;
    private LocalDateTime saleDate;
    private Double salePrice;
    private PaymentMethod paymentMethod;
    private SaleStatus status;
    private String notes;

    public SaleCreateDTO() {
    }

    public SaleCreateDTO(UUID id, UUID vehicleId, UUID customerId, UUID sellerId, LocalDateTime saleDate,
                        Double salePrice, PaymentMethod paymentMethod, SaleStatus status, String notes) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.notes = notes;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public void setSellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
