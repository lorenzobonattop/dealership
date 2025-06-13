package com.lorenzodev.concessionaria.models.enums;

public enum Fuel {
    GASOLINA("Gasolina"),
    ETANOL("Etanol"),
    DIESEL("Diesel"),
    FLEX("Flex (Gasolina/Etanol)"),
    GNV("GNV"),
    HIBRIDO("Híbrido"),
    ELETRICO("Elétrico");

    private final String description;

    Fuel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}