package com.example.alfa;
import javax.swing.event.ChangeListener;
import com.example.alfa.model.Register;
import com.example.alfa.model.RegisterList;
import com.example.alfa.model.Type;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.util.Comparator.comparing;

public class mainController implements Initializable {


    @FXML
    private Label lblBalance;

    public static Label balance;

    public static TableView sTableView;
    @FXML
    private TableView<Register> tableView;

    @FXML
    private TableColumn<Register, Double> colAmount;

    @FXML
    private TableColumn<Register, String> colDescription;

    @FXML
    private TableColumn<Register, Type> colType;

    @FXML
    private TableColumn<Register, Date> colDate;

    @FXML
    private Button btnIncomes;
    @FXML
    private Button btnExpenses;
    @FXML
    private Button btnCombined;
    @FXML
    private Button btnRegister;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.setItems(RegisterList.getInstance().getRegisters());

        btnRegister.setOnAction(e -> {
            HelloApplication.openWindow("register.fxml");
        });

        btnIncomes.setOnAction(actionEvent -> {
            showBtnIncomes();
        });

        btnExpenses.setOnAction(actionEvent -> {
            showBtnExpenses();
        });

        btnCombined.setOnAction(actionEvent -> {
            showBtnCombined();
        });
        balance = lblBalance;
        sTableView = tableView;
        balance.setText("0.0");
    }
    @FXML
    private void showBtnIncomes(){
        sTableView.setItems(RegisterList.getInstance().getRegisters().filtered(register -> register.getType() == Type.INCOME).sorted(Comparator.comparing(Register::getDate).reversed()));


    }

    @FXML
    private void showBtnExpenses(){
        sTableView.setItems(RegisterList.getInstance().getRegisters().filtered(register -> register.getType() == Type.EXPENSE).sorted(Comparator.comparing(Register::getDate).reversed()));
    }
    @FXML
    private void showBtnCombined(){
        RegisterList.getInstance().getRegisters().sort(Comparator.comparing(Register::getDate).reversed());
        sTableView.setItems(RegisterList.getInstance().getRegisters());
    }



}