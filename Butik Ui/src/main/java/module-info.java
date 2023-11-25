module com.example.butikui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.butikui to javafx.fxml;
    exports com.example.butikui;
}