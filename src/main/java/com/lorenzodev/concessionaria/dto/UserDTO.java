package com.lorenzodev.concessionaria.dto;

import java.util.UUID;

import com.lorenzodev.concessionaria.models.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private UserRole role;
    private String phone;
    private Boolean isActive;
}