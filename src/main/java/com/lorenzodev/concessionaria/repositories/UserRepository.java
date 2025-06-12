package com.lorenzodev.concessionaria.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorenzodev.concessionaria.models.User;

public interface UserRepository extends JpaRepository<User, UUID>{
}