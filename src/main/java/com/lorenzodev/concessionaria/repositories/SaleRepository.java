package com.lorenzodev.concessionaria.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorenzodev.concessionaria.models.Sale;

public interface SaleRepository extends JpaRepository <Sale, UUID>{
}