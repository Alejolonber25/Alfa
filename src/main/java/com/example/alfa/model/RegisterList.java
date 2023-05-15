package com.example.alfa.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RegisterList {

    private ObservableList<Register> registers = FXCollections.observableArrayList();
    private RegisterList(){}

    private static RegisterList instance = null;

    public static RegisterList getInstance(){
        if(instance == null){
            instance = new RegisterList();
        }
        return instance;
    }

    public ObservableList<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(ObservableList<Register> registers) {
        this.registers = registers;
    }
}
