package com.lorenzodev.concessionaria.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorenzodev.concessionaria.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID>{
}