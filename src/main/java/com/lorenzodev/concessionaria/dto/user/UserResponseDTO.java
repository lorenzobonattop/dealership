package com.lorenzodev.concessionaria.dto.user;

import java.time.LocalDateTime;
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
public class UserResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private UserRole role;
    private String phone;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}