package com.lorenzodev.concessionaria.models.enums;

public enum UserRole {
    ADMIN("Administrador"),
    MANAGER("Gerente"),
    SELLER("Vendedor"),
    CUSTOMER("Cliente");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}