package com.lorenzodev.concessionaria.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lorenzodev.concessionaria.dto.SaleDTO;
import com.lorenzodev.concessionaria.models.Sale;
import com.lorenzodev.concessionaria.models.User;
import com.lorenzodev.concessionaria.models.Vehicle;
import com.lorenzodev.concessionaria.repositories.SaleRepository;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Transactional
    public SaleDTO createSale(SaleDTO saleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(saleDTO.getVehicleId());

        User customer = new User();
        customer.setId(saleDTO.getCustomerId());

        Sale sale = new Sale();
        sale.setVehicle(vehicle);
        sale.setCustomer(customer);
        sale.setSaleDate(saleDTO.getSaleDate());
        sale.setSalePrice(saleDTO.getSalePrice());
        sale.setPaymentMethod(saleDTO.getPaymentMethod());
        sale.setStatus(saleDTO.getStatus());
        sale.setNotes(saleDTO.getNotes());
        sale.setCreatedAt(LocalDateTime.now());
        sale.setUpdatedAt(LocalDateTime.now());

        saleRepository.save(sale);

        SaleDTO responseDTO = new SaleDTO();
        responseDTO.setId(sale.getId());
        responseDTO.setVehicleId(sale.getVehicle().getId());
        responseDTO.setCustomerId(sale.getCustomer().getId());
        responseDTO.setSaleDate(sale.getSaleDate());
        responseDTO.setSalePrice(sale.getSalePrice());
        responseDTO.setPaymentMethod(sale.getPaymentMethod());
        responseDTO.setStatus(sale.getStatus());
        responseDTO.setNotes(sale.getNotes());
        responseDTO.setCreatedAt(sale.getCreatedAt());
        responseDTO.setUpdatedAt(sale.getUpdatedAt());

        return responseDTO;
    }

    @Transactional(readOnly = true)
    public SaleDTO getSaleById(UUID id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setId(sale.getId());
        saleDTO.setVehicleId(sale.getVehicle().getId());
        saleDTO.setCustomerId(sale.getCustomer().getId());
        saleDTO.setSaleDate(sale.getSaleDate());
        saleDTO.setSalePrice(sale.getSalePrice());
        saleDTO.setPaymentMethod(sale.getPaymentMethod());
        saleDTO.setStatus(sale.getStatus());
        saleDTO.setNotes(sale.getNotes());
        saleDTO.setCreatedAt(sale.getCreatedAt());
        saleDTO.setUpdatedAt(sale.getUpdatedAt());

        return saleDTO;
    }

    @Transactional
    public SaleDTO updateSale(UUID id, SaleDTO saleDTO) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));

        Vehicle vehicle = new Vehicle();
        vehicle.setId(saleDTO.getVehicleId());

        User customer = new User();
        customer.setId(saleDTO.getCustomerId());

        sale.setVehicle(vehicle);
        sale.setCustomer(customer);
        sale.setSaleDate(saleDTO.getSaleDate());
        sale.setSalePrice(saleDTO.getSalePrice());
        sale.setPaymentMethod(saleDTO.getPaymentMethod());
        sale.setStatus(saleDTO.getStatus());
        sale.setNotes(saleDTO.getNotes());
        sale.setUpdatedAt(LocalDateTime.now());

        saleRepository.save(sale);

        SaleDTO responseDTO = new SaleDTO();
        responseDTO.setId(sale.getId());
        responseDTO.setVehicleId(sale.getVehicle().getId());
        responseDTO.setCustomerId(sale.getCustomer().getId());
        responseDTO.setSaleDate(sale.getSaleDate());
        responseDTO.setSalePrice(sale.getSalePrice());
        responseDTO.setPaymentMethod(sale.getPaymentMethod());
        responseDTO.setStatus(sale.getStatus());
        responseDTO.setNotes(sale.getNotes());
        responseDTO.setCreatedAt(sale.getCreatedAt());
        responseDTO.setUpdatedAt(sale.getUpdatedAt());

        return responseDTO;
    }

    @Transactional
    public void deleteSale(UUID id) {
        saleRepository.deleteById(id);
    }
}   