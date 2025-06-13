package com.lorenzodev.concessionaria.dto.user;

import com.lorenzodev.concessionaria.models.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
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

    @Email(message = "Email inválido")
    private String email;

    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
        message = "A senha deve conter pelo menos 8 caracteres, uma letra maiúscula, uma minúscula, um número e um caractere especial"
    )
    private String password;

    private UserRole role;

    @Pattern(regexp = "^\\+?[1-9][0-9]{10,14}$", message = "Formato de telefone inválido")
    private String phone;

    private Boolean isActive;
} 