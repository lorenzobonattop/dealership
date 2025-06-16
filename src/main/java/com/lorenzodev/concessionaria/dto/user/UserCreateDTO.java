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
public class UserCreateDTO {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private UserRole role;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}