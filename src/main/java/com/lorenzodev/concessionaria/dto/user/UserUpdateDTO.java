package com.lorenzodev.concessionaria.dto.user;

import java.time.LocalDateTime;

import com.lorenzodev.concessionaria.models.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private Boolean isActive;
    private UserRole role;
    private LocalDateTime updatedAt;
}