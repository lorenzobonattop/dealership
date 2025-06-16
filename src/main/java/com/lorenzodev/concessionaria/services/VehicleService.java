package com.lorenzodev.concessionaria.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lorenzodev.concessionaria.dto.VehicleDTO;
import com.lorenzodev.concessionaria.models.Vehicle;
import com.lorenzodev.concessionaria.repositories.VehicleRepository;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleDTO.getName());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setFuel(vehicleDTO.getFuel());
        vehicle.setTransmission(vehicleDTO.getTransmission());
        vehicle.setMileage(vehicleDTO.getMileage());
        vehicle.setDescription(vehicleDTO.getDescription());
        vehicle.setIsAvailable(vehicleDTO.getIsAvailable());
        vehicle.setCreatedAt(LocalDateTime.now());
        vehicle.setUpdatedAt(LocalDateTime.now());
        
        vehicleRepository.save(vehicle);

        VehicleDTO responseDTO = new VehicleDTO();
        responseDTO.setId(vehicle.getId());
        responseDTO.setName(vehicle.getName());
        responseDTO.setBrand(vehicle.getBrand());
        responseDTO.setModel(vehicle.getModel());
        responseDTO.setYear(vehicle.getYear());
        responseDTO.setPrice(vehicle.getPrice());
        responseDTO.setColor(vehicle.getColor());
        responseDTO.setFuel(vehicle.getFuel());
        responseDTO.setTransmission(vehicle.getTransmission());
        responseDTO.setMileage(vehicle.getMileage());
        responseDTO.setDescription(vehicle.getDescription());
        responseDTO.setIsAvailable(vehicle.getIsAvailable());
        responseDTO.setCreatedAt(vehicle.getCreatedAt());
        responseDTO.setUpdatedAt(vehicle.getUpdatedAt());

        return responseDTO;
    }

    @Transactional(readOnly = true)
    public VehicleDTO getVehicleById(UUID id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setName(vehicle.getName());
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setYear(vehicle.getYear());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setColor(vehicle.getColor());
        vehicleDTO.setFuel(vehicle.getFuel());
        vehicleDTO.setTransmission(vehicle.getTransmission());
        vehicleDTO.setMileage(vehicle.getMileage());
        vehicleDTO.setDescription(vehicle.getDescription());
        vehicleDTO.setIsAvailable(vehicle.getIsAvailable());
        vehicleDTO.setCreatedAt(vehicle.getCreatedAt());
        vehicleDTO.setUpdatedAt(vehicle.getUpdatedAt());

        return vehicleDTO;
    }

    @Transactional
    public VehicleDTO updateVehicle(UUID id, VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        
        vehicle.setName(vehicleDTO.getName());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setFuel(vehicleDTO.getFuel());
        vehicle.setTransmission(vehicleDTO.getTransmission());
        vehicle.setMileage(vehicleDTO.getMileage());
        vehicle.setDescription(vehicleDTO.getDescription());
        vehicle.setIsAvailable(vehicleDTO.getIsAvailable());
        vehicle.setUpdatedAt(LocalDateTime.now());
        
        vehicleRepository.save(vehicle);

        VehicleDTO responseDTO = new VehicleDTO();
        responseDTO.setId(vehicle.getId());
        responseDTO.setName(vehicle.getName());
        responseDTO.setBrand(vehicle.getBrand());
        responseDTO.setModel(vehicle.getModel());
        responseDTO.setYear(vehicle.getYear());
        responseDTO.setPrice(vehicle.getPrice());
        responseDTO.setColor(vehicle.getColor());
        responseDTO.setFuel(vehicle.getFuel());
        responseDTO.setTransmission(vehicle.getTransmission());
        responseDTO.setMileage(vehicle.getMileage());
        responseDTO.setDescription(vehicle.getDescription());
        responseDTO.setIsAvailable(vehicle.getIsAvailable());
        responseDTO.setCreatedAt(vehicle.getCreatedAt());
        responseDTO.setUpdatedAt(vehicle.getUpdatedAt());

        return responseDTO;
    }

    @Transactional
    public void deleteVehicle(UUID id) {
        vehicleRepository.deleteById(id);
    }
}