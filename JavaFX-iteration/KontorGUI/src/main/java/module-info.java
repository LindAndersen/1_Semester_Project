module com.example.kontorgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kontorgui to javafx.fxml;
    exports com.example.kontorgui;
}