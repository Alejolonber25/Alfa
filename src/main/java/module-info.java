module com.example.alfa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.alfa.model to javafx.base;
    opens com.example.alfa to javafx.fxml;
    exports com.example.alfa;
}
