package com.lorenzodev.concessionaria.models.enums;

public enum  PaymentMethod{
    CASH("Dinheiro"),
    CREDIT_CARD("Cartão de Crédito"),
    DEBIT_CARD("Cartão de Débito"),
    BANK_TRANSFER("Transferência Bancária"),
    FINANCING("Financiamento");

    private final String description;

    PaymentMethod(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}