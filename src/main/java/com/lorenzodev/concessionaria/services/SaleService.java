package com.lorenzodev.concessionaria.services;

import java.util.UUID;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.lorenzodev.concessionaria.repositories.SaleRepository;
import com.lorenzodev.concessionaria.models.Sale;
import com.lorenzodev.concessionaria.models.Vehicle;
import com.lorenzodev.concessionaria.models.User;
import com.lorenzodev.concessionaria.dto.SaleDTO;

@Service
@RequiredArgsConstructor
public class SaleService{
    private final SaleRepository saleRepository;

    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale sale = Sale.builder()
            .vehicle(Vehicle.builder().id(saleDTO.getVehicleId()).build())
            .customer(User.builder().id(saleDTO.getCustomerId()).build())
            .saleDate(saleDTO.getSaleDate())
            .salePrice(saleDTO.getSalePrice())
            .status(saleDTO.getStatus())
            .build();
        saleRepository.save(sale);
        return SaleDTO.builder()
            .id(sale.getId())
            .vehicleId(sale.getVehicle().getId())
            .customerId(sale.getCustomer().getId())
            .saleDate(sale.getSaleDate())
            .salePrice(sale.getSalePrice())
            .paymentMethod(sale.getPaymentMethod())
            .status(sale.getStatus())
            .notes(sale.getNotes())
            .build();
    }

    public SaleDTO getSaleById(UUID id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        return SaleDTO.builder()
            .id(sale.getId())
            .vehicleId(sale.getVehicle().getId())
            .customerId(sale.getCustomer().getId())
            .saleDate(sale.getSaleDate())
            .salePrice(sale.getSalePrice())
            .paymentMethod(sale.getPaymentMethod())
            .status(sale.getStatus())
            .notes(sale.getNotes())
            .build();
    }

    public SaleDTO updateSale(UUID id, SaleDTO saleDTO) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        sale.setVehicle(Vehicle.builder().id(saleDTO.getVehicleId()).build());
        sale.setCustomer(User.builder().id(saleDTO.getCustomerId()).build());
        sale.setSaleDate(saleDTO.getSaleDate());
        sale.setSalePrice(saleDTO.getSalePrice());
        sale.setPaymentMethod(saleDTO.getPaymentMethod());
        sale.setStatus(saleDTO.getStatus());
        sale.setNotes(saleDTO.getNotes());
        saleRepository.save(sale);
        return SaleDTO.builder()
            .id(sale.getId())
            .vehicleId(sale.getVehicle().getId())
            .customerId(sale.getCustomer().getId())
            .saleDate(sale.getSaleDate())
            .salePrice(sale.getSalePrice())
            .paymentMethod(sale.getPaymentMethod())
            .status(sale.getStatus())
            .notes(sale.getNotes())
            .build();
    }

    public void deleteSale(UUID id) {
        saleRepository.deleteById(id);
    }
}   