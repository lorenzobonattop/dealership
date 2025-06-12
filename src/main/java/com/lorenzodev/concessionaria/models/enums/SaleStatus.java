package com.lorenzodev.concessionaria.models.enums;

public enum SaleStatus{
    PENDING("Pendente"),
    COMPLETED("Concluída"),
    CANCELLED("Cancelada"),
    REFUNDED("Reembolsada");

    private final String description;

    SaleStatus(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}