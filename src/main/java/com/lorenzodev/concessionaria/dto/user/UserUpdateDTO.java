package com.lorenzodev.concessionaria.dto.user;

import java.time.LocalDateTime;
import java.util.Objects;

import com.lorenzodev.concessionaria.models.enums.UserRole;

public class UserUpdateDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private Boolean isActive;
    private UserRole role;
    private LocalDateTime updatedAt;

    public UserUpdateDTO() {
    }

    public UserUpdateDTO(String name, String email, String password, String phone, Boolean isActive, UserRole role, LocalDateTime updatedAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.isActive = isActive;
        this.role = role;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserUpdateDTO that = (UserUpdateDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(phone, that.phone) && Objects.equals(isActive, that.isActive) && role == that.role && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, phone, isActive, role, updatedAt);
    }
}