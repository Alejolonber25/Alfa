package com.example.alfa;

import java.io.IOException;
import java.net.URL;

import java.util.Comparator;
import java.util.ResourceBundle;


import com.example.alfa.model.Register;
import com.example.alfa.model.RegisterList;
import com.example.alfa.model.Type;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.alfa.mainController.*;

public class registerController implements Initializable{
    @FXML
    private TextField inptAmount;

    @FXML
    private TextField inptDescription;

    @FXML
    private DatePicker dtDate;

    @FXML
    private ChoiceBox<Type> cbType;

    @FXML
    private Button btnRegister;


    @FXML
    public void add(ActionEvent event) throws IOException {
        Register register = new Register(
                Double.parseDouble(inptAmount.getText()),
                inptDescription.getText(),
                cbType.getValue(),
                dtDate.getValue()

                );
        RegisterList.getInstance().getRegisters().add(register);
        Stage stage = (Stage) btnRegister.getScene().getWindow();
        stage.close();

        double totalIncome = 0;
        double totalExpense = 0;

        for (Register r : RegisterList.getInstance().getRegisters()) {
            if (r.getType() == Type.INCOME) {
                totalIncome += r.getAmount();
            } else if (r.getType() == Type.EXPENSE) {
                totalExpense += r.getAmount();
            }
        }


        balance.setText( String.valueOf(totalIncome-totalExpense));
        sTableView.setItems(  RegisterList.getInstance().getRegisters().sorted(Comparator.comparing(Register::getDate).reversed()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Type[] types = Type.values();
        ObservableList<Type> typeList = FXCollections.observableArrayList(types);
        cbType.setItems(typeList);
    }
}
