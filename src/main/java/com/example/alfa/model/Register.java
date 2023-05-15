package com.example.alfa.model;

import java.time.LocalDate;

public class Register {
    double amount;
    String description;
    Type type;
    LocalDate date;

    public Register(double amount, String description, Type type, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
